// To overload to find the area (circle, rect), reverse int or array, validate name and age

import java.util.*;

public class _19_Method_Overloading {
    public static void main(String[] args) {
//        String name = "Raman";
//        System.out.println(validate(name));
        printVarArg(1,2,3,4,5);
        printVarArg(new int[] {10, 20, 30, 40, 50});
    }

    // ellipsis passing
    static void printVarArg(int ...X) {
        for (int x: X)
            System.out.printf("%d ", x);
        System.out.println();
    }

    static double calculateArea(int r) {
        return Math.PI * Math.pow(r, 2);
    }

    static double calculateArea(int x, int y) {
        return x * y;
    }

    static int reverse(int x) {
        int y = 0;
        while (x > 0) {
            y = 10 * y + x % 10;
            x = x / 10;
        }
        return y;
    }

    static void reverse(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
    }

    static boolean validate(String name) {
        return name.matches("[a-zA-Z]*");
    }

    static boolean validate(int age) {
        return age >= 0 && age <= 100;
    }
}