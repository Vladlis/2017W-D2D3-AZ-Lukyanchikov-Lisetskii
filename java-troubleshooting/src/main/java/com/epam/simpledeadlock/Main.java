package com.epam.simpledeadlock;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    private static final Object criticalOne = new Object();
    private static final Object criticalTwo = new Object();

    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(new FirstThread());
        executor.execute(new SecondThread());
    }

    public static class FirstThread implements Runnable {
        public void run() {
            foo();
        }
    }

    public static class SecondThread implements Runnable {
        public void run() {
            bar();
        }
    }

    private static void foo() {
        synchronized (criticalOne) {
            try {
                Thread.sleep(1000);
                bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void bar() {
        synchronized (criticalTwo) {
            try {
                Thread.sleep(1000);
                foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
