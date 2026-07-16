// To use operators in java

import java.util.*;

public class _03_Operators1 {
    public static void main(String[] args) {
        // find area of triangle using heron's formula
        // Area = sqrt(s*(s-a)*(s-b)*(s-c))
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the lengths of the triangle's sides");
        
        System.out.print("Enter side a: ");
        double a = sc.nextDouble();
        
        System.out.print("Enter side b: ");
        double b = sc.nextDouble();
        
        System.out.print("Enter side c: ");
        double c = sc.nextDouble();

        if (!isValidTriangle(a, b, c))
            System.out.println("Invalid triangle");
        else {
            double s = (a + b + c) / 2.0;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            System.out.printf("Area of the triangle: %.2f sq. units", area);
        }
        sc.close();
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        // Triangle inequality: sum of two sides of triangle exceeds third side
        return (a + b) > c && (b + c) > a && (a + c) > b;
    }
}