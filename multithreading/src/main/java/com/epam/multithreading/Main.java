package com.epam.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Main {

    private static final int CARS_NUMBER = 5;
    private static final int NUMBER_OF_DISQUALIFIED_CARS = 2;
    private static final int FRICTION_GENERATED_PART = 50;
    private static final int FRICTION_LOWER_BOUND = 10;
    private static final long RACE_DISTANCE = 10000;
    private static final long STEP_DISTANCE = 100;

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(CARS_NUMBER - NUMBER_OF_DISQUALIFIED_CARS);
        Thread[] carThreads = new Thread[CARS_NUMBER];
        Random random = new Random();

        for (int i = 0; i < CARS_NUMBER; i++) {
            carThreads[i] = new Thread(new Car(
                    "Car #" + (i + 1),
                    FRICTION_LOWER_BOUND + random.nextInt(FRICTION_GENERATED_PART),
                    barrier, RACE_DISTANCE, STEP_DISTANCE));
        }

        for (Thread carThread : carThreads) {
            carThread.start();
        }

        Thread.currentThread().sleep(RACE_DISTANCE / STEP_DISTANCE * FRICTION_LOWER_BOUND / 2);

        List<Integer> disqualifiedCarIndexes = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_DISQUALIFIED_CARS; i++) {
            int disqualifiedCarIndex = random.nextInt(CARS_NUMBER);
            while (disqualifiedCarIndexes.contains(disqualifiedCarIndex)) {
                disqualifiedCarIndex = disqualifiedCarIndex++ % CARS_NUMBER;
            }
            disqualifiedCarIndexes.add(disqualifiedCarIndex);
            carThreads[disqualifiedCarIndex].interrupt();
        }
    }
}
