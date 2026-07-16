// To understand OOP in java

import java.util.*;

public class _20_OOP {
    public static void main(String[] args) {
        /*
        Circle c1 = new Circle(5, -1, -2);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Circumference: " + c1.getCircumference());
        System.out.println(c1);
        c1.setRadius(10);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        */

        Cylinder cl1 = new Cylinder(5, 4);
        System.out.println(cl1);
        System.out.println("Area: " + cl1.getArea());
        System.out.println("Perimeter: " + cl1.getPerimeter());
    }
}

class Cylinder {
    private double radius;
    private double height;

    public Cylinder(double r, double h) {
        radius = r;
        height = h;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public void setRadius(double r) {
        radius = (r > 0) ? r : 0;
    }

    public void setHeight(double h) {
        height = (h > 0) ? h : 0;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius * (radius + height);
    }

    public double getArea() {
        return Math.PI * radius * radius * height;
    }
    
    public String toString() {
        return "Radius: " + getRadius() + "\nHeight: " + getHeight();
    }
}

class Circle {
    private double radius;
    private double x0, y0;

    public Circle(double r, double x0, double y0) {
        radius = r;
        x0 = x0;
        y0 = y0;
    }

    @Override
    public String toString() {
        return "Radius: " + radius + "\nCentre: (" + x0 + ", " + y0 + ")";
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void setRadius(double r) {
        radius = r;
    }

    public void setCentre(double x, double y) {
        x0 = x;
        y0 = y;
    }
}