package com.epam.jmm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Random random = new Random(42);
            List<BigDecimal> list;
            while (true) {
                list = new ArrayList<>();
                int bound = random.nextBoolean() ? 100 : 101;
                for (long i = 0; i < bound; i++) {
                    list.add(new BigDecimal(random.nextDouble()));
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1_000 * 60 * 5);
    }
}
