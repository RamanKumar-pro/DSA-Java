// Check primality, find gcd, find max in array

import java.util.*;

public class _18_Ques {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(n + " is " + (isPrime(n) ? "" : "not ") + "a prime");

        int a = 19, b = 235;
        System.out.printf("gcd (%d, %d) = %d\n", a, b, gcd(a,b));

        int[] arr = {10, 3, 6, 9, 13, 2};
        System.out.println("Max element: " + getMax(arr));
    }

    static boolean isPrime(int x) {
        for(int i = 2; i < Math.sqrt(x); ++i)
            if (x % 2 == 0)
                return false;
        return true;
    }

    static int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }

    static int getMax(int[] A) {
        int maxEle = A[0];
        for (int a: A)
            if (a > maxEle)
                maxEle = a;
        return maxEle;
    }
}