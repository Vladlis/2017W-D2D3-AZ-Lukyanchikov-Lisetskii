package com.epam.java8;

public class NewPoint {
    private double a;
    private double b;

    public NewPoint(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewPoint newPoint = (NewPoint) o;

        if (Double.compare(newPoint.a, a) != 0) return false;
        if (Double.compare(newPoint.b, b) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "NewPoint{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
