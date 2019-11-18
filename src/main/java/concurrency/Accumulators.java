/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO: Javadoc
 */
public final class Accumulators {

    public static void main(String[] args) throws InterruptedException {
        AtomicLong counter = new AtomicLong(0);
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task(counter));
        }
        Thread.sleep(2000);
        System.out.println(counter.get());
    }



    private static class Task implements Runnable{

        private final AtomicLong counter;

        public Task(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.incrementAndGet();
        }
    }
}
