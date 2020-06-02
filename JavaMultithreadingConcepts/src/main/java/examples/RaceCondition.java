package examples;

import java.util.Random;

public class RaceCondition {
    int randInt;
    Random random = new Random(System.currentTimeMillis());


    private void printDivisibleByFive() {
        int i = 1000000;
        while (i > 0) {
            if (randInt % 5 == 0) {
                if (randInt % 5 != 0)
                    System.out.println(randInt);
            }
            i--;
        }
    }

    private void decrementer() {
        int i = 1000000;
        while (i > 0) {
            randInt = random.nextInt(1000);
            i--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final RaceCondition raceCondition = new RaceCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                raceCondition.printDivisibleByFive();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                raceCondition.decrementer();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
