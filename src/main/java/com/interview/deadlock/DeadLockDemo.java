package com.interview.deadlock;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Mike on 2017-04-15.
 */
public class DeadLockDemo {

    private static final Logger log =LoggerFactory.getLogger(DeadLockDemo.class);

    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public DeadLockDemo() {
        Thread t1 =new ThreadDemo1();
        Thread t2 =new ThreadDemo2();

        t1.start();
        t2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            while(true) {
                synchronized (object1) {
                    log.info("Thread 1: Holding lock 1...");

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                    }
                    log.info("Thread 1: Waiting for lock 2...");

                    synchronized (object2) {
                        log.info("Thread 1: Holding lock 1 & 2...");
                    }
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            while(true) {
                synchronized (object2) {
                    log.info("Thread 2: Holding lock 2...");

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                    }
                    log.info("Thread 2: Waiting for lock 1...");

                    synchronized (object1) {
                        log.info("Thread 2: Holding lock 1 & 2...");
                    }
                }
            }
        }
    }
}
