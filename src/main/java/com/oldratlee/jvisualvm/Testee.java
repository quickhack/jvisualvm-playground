package com.oldratlee.jvisualvm;

import java.util.Date;

/**
 * @author Jerry Lee
 */
public class Testee {
    static long countTimeIn500ms = 0;

    public static void main(String[] args) throws Exception {
        countTimeIn500ms = guessCountTimeIn500ms();

        Thread runAndSleepTask = new Thread(new RunAndSleepTask(), "RunAndSleepTask");
        Thread runAndWaitTask = new Thread(new RunAndWaitTask(), "RunAndWaitTask");
        Thread runAndLongSleepTask = new Thread(new RunAndLongSleepTask(), "RunAndLongSleepTask");

        runAndSleepTask.start();
        runAndWaitTask.start();
        runAndLongSleepTask.start();

        System.out.println("Tasks started!");
        Thread.sleep(Long.MAX_VALUE);
    }

    public static class RunAndSleepTask implements Runnable {
        @Override
        public void run() {
            String name = this.getClass().getSimpleName();
            while (true) {
                for (long i = 0; i < countTimeIn500ms; i++) {
                }
                System.out.println(name + ": " + new Date());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class RunAndWaitTask implements Runnable {
        @Override
        public void run() {
            String name = this.getClass().getSimpleName();
            while (true) {
                for (long i = 0; i < countTimeIn500ms; i++) {
                }
                try {
                    System.out.println(name + ": " + new Date());
                    synchronized (this) {
                        this.wait(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class RunAndLongSleepTask implements Runnable {
        @Override
        public void run() {
            String name = this.getClass().getSimpleName();
            while (true) {
                for (long i = 0; i < countTimeIn500ms; i++) {
                }
                System.out.println(name + ": " + new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @return 100ms可以做{@code long}的计数次数。
     */
    static long guessCountTimeIn500ms() {
        System.out.println("start guess.");

        long count = 1000L * 1000 * 1000;

        // simple warm-up
        for (long i = 0; i < count; i++) {
            // nothing!
        }

        long tick = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            // nothing!
        }
        long duration = System.currentTimeMillis() - tick;
        System.out.printf("1G times count take %d ms.\n", duration);

        return count * 500 / duration;
    }
}
