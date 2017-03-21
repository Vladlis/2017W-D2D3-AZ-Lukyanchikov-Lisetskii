package com.epam.soap.util;

public class Utils {

    private Utils() {}

    public static double calculateFactorial(double value) {
        if (value > 1) {
            return value * calculateFactorial(value - 1);
        } else {
            return value;
        }
    }
}
