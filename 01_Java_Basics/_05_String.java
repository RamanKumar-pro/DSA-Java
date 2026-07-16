// To understand the string functions in java
// Strings are immutable objects which represent sequence of characters.
// To modify a string an entirely new string object is created.
// StringBuilder -> mutable character sequence for single thread
// StringBuffer -> mutable thread safe character sequence for multi threading

import java.util.*;

public class _05_String {
    public static void main(String[] args) {
        int x = 10, y = 20;
        System.out.println("Sum " + x + " + " + y + " is " + (x + y));
        System.out.println(x + y + " is the sum");
        System.out.println("Sum: " + x + y); // Sum: 1020
        System.out.println("Sum: " + (x + y)); // Sum: 30
        double var = 234.75189;
        System.out.printf("%.2f", var);
    }
}