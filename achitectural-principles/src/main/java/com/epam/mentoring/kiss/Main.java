package com.epam.mentoring.kiss;

public class Main {

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("At least three arguments must be entered: height, upRadius, downRadius.");
        }
        try {
            double height = Double.valueOf(args[0]);
            double upRadius = Double.valueOf(args[1]);
            double downRadius = Double.valueOf(args[2]);
            System.out.println(getSphericalShellVolumeComplex(height, upRadius, downRadius));
            System.out.println(getSphericalShellVolumeSimple(height, upRadius, downRadius));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Arguments must be numbers.");
        }
    }

    /**
     * KISS is applied
     */
    private static double getSphericalShellVolumeSimple(double height, double upRadius, double downRadius) {
        return 0.5 * Math.PI * (Math.pow(upRadius, 2) + Math.pow(downRadius, 2) - 1 / 3 * Math.pow(height, 2));
    }

    /**
     * KISS is not applied
     */
    private static double getSphericalShellVolumeComplex(double height, double upRadius, double downRadius) {
        return 1 / 2 * 3.14159265358979323846 * (upRadius * upRadius + downRadius * downRadius - 1 / 3 * height * height * height);
    }
}
