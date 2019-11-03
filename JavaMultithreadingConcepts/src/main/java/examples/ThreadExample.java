package examples;

import threadInfo.ThreadDetails;

public class ThreadExample extends Thread {

    @Override
    public void run() {
        synchronized(ThreadExample.class) {
            ThreadDetails.printThreadDetails(Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();
        threadExample.start();
    }
}
