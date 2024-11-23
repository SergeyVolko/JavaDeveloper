package com.example.circle;

/**
 * Заполните этот класс в соответсвии с заданием из лекции.
 */
public class Circle {
    private double radius;

    public Circle(double radius) {
        checkingRadius(radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        checkingRadius(radius);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    private void checkingRadius(double radius) {
        if (radius < 0) {
            throw new RuntimeException("Radius less than zero");
        }
    }
}
