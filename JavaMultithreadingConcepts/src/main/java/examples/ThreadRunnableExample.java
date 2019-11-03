package examples;

import threadInfo.ThreadDetails;

public class ThreadRunnableExample implements Runnable {
    public void run() {
        ThreadDetails.printThreadDetails(Thread.currentThread());
    }

    public static void main(String[] args) {
        Thread threadRunnableExample = new Thread(new ThreadRunnableExample(), "Runnable Example");
        threadRunnableExample.start();
    }
}
