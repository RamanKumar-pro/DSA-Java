// To rotate an array

import java.util.*;

public class _14_rotate_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // take user input array
        System.out.print("Enter length of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            System.out.printf("Enter arr[%d]: ",i);
            arr[i] = sc.nextInt();
        }
        displayArray(arr);
        System.out.print("Enter the rotations: ");
        int k = sc.nextInt();
        k = k % n;

        // reverse first part n - k elements and then second of k elements then reverse whole array
        revArray(arr, 0, n - k);
        revArray(arr, n - k, n);
        revArray(arr, 0, n);
        displayArray(arr);
        sc.close();
    }

    private static void displayArray(int[] arr) {
        System.out.print("Array: [");
        for(int x: arr)
            System.out.print(x + " ");
        System.out.println("\b]");
    }

    private static void revArray(int[] arr, int start, int end) {
        int l = start, r = end - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}