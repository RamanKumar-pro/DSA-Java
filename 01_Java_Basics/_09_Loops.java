// To use loops in java

import java.util.*;

public class _09_Loops {
    public static void main(String[] args) {
        System.out.println("For Loop");
        for(int i = 0; i < 10; ++i) {
            System.out.println("i: " + i);
        }

        System.out.println("\nWhile Loop");
        int i = 0;
        while (i < 10) {
            System.out.println("i: " + i);
            i++;
        }

        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Array: " + arr);
    }
}