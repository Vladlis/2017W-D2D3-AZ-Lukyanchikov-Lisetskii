package com.epam.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final int NUMBER_OF_POINTS = 10;
    private static final int GENERATOR_MULTIPLIER = 10;
    private static final int GENERATOR_SEED = 42;

    public static void main(String[] args) {
        List<Point> points = generatePoints(NUMBER_OF_POINTS);

        System.out.println("Points:");
        points.forEach(System.out::println);

        List<NewPoint> newPoints = points.stream()
                .map(point -> new NewPoint(point.getX(), point.getY()))
                .filter(newPoint -> newPoint.getA() > 3 && newPoint.getB() > 3)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Filtered NewPoints:");
        newPoints.forEach(System.out::println);

        double sum = newPoints.stream()
            .mapToDouble(newPoint -> newPoint.getA() + newPoint.getB())
            .sum();
        System.out.println("Sum of filtered NewPoints coordinates: " + sum);

        double multiplication = newPoints.stream()
            .mapToDouble(newPoint -> newPoint.getA() * newPoint.getB())
            .reduce((double a, double b) -> a * b)
            .getAsDouble();
        System.out.println("Sum of filtered NewPoints coordinates: " + multiplication);
    }

    private static List<Point> generatePoints(int pointsNumber) {
        List<Point> points = new ArrayList<>();
        Random generator = new Random(GENERATOR_SEED);

        for (int i = 0; i < pointsNumber; i++) {
            double x = generator.nextDouble() * GENERATOR_MULTIPLIER;
            double y = generator.nextDouble() * GENERATOR_MULTIPLIER;
            points.add(new Point(x, y));
        }
        return points;
    }
}
