// Hand's on array in Java

import java.util.*;

public class _13_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            System.out.print("Enter arr[" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        displayArray(arr);
        sc.close();
    }

    private static void displayArray(int[] arr) {
        System.out.print("Array: [");
        for (int x : arr)
            System.out.print(x++ + " ");
        System.out.println("\b]");
    }
}