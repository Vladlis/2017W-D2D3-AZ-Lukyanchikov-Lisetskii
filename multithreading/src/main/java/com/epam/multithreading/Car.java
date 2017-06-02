package com.epam.multithreading;

import org.apache.log4j.Logger;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private Logger log = Logger.getLogger(getClass());
    private long friction;
    private long distance;
    private String name;
    private CyclicBarrier barrier;
    private long raceDistance;
    private long stepDistance;

    public Car(String name, long friction, CyclicBarrier barrier, long raceDistance, long stepDistance) {
        this.name = name;
        this.friction = friction;
        this.barrier = barrier;
        this.raceDistance = raceDistance;
        this.stepDistance = stepDistance;
    }

    @Override
    public void run() {
        try {
            while (distance < raceDistance) {
                Thread.sleep(friction);
                distance += stepDistance;
                log.info(name + " " + distance);
            }
            int position = barrier.await();
            if (position ==  barrier.getParties() - 1) {
                System.out.println("The winner is " + name + "!");
            }
        } catch (InterruptedException | BrokenBarrierException ex) {
            log.error(name + ": ", ex);
        }
    }
}
