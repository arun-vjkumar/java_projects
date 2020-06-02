package examples;

public class DeadLock {

    private int counter = 0;
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    private Runnable incrementer = new Runnable() {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    incrementCounter();
                    System.out.println("Incrementing " + i);
                }
            } catch (Exception e) {
            }
        }
    };

    private Runnable decrementer = new Runnable() {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    decrementCounter();
                    System.out.println("Incrementing " + i);
                }
            } catch (Exception e) {
            }
        }
    };

    void incrementCounter() throws InterruptedException {
        synchronized (obj1) {
            System.out.println("Acquired Obj1");
            Thread.sleep(100);
            synchronized (obj2) {
                counter++;
            }
        }
    }

    void decrementCounter() throws InterruptedException {
        synchronized (obj2) {
            System.out.println("Acquired Obj2");
            Thread.sleep(100);
            synchronized (obj1) {
                counter--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock = new DeadLock();
        Thread thread1 = new Thread(deadLock.incrementer);
        Thread thread2 = new Thread(deadLock.decrementer);

        thread1.start();
        // sleep to make sure thread 1 gets a chance to acquire lock1
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Done : " + deadLock.counter);
    }
}
