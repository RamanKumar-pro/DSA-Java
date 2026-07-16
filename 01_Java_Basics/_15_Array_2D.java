// To try 2D array in java

import java.util.Scanner;

public class _15_Array_2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr1 = {1, 2, 3, 4, 5};

        int[][] arr2 = {
            {1, 3, 4, 5},
            {34, 54, 23, 65},
            {2, 3, 9, 12, 4, 3, 1}
        };

        System.out.println("Displaying 1D Array:");
        displayArray(arr1);

        System.out.println("\nDisplaying 2D Array (row by row):");
        for (int[] row : arr2) {
            displayArray(row);
        }
        
        sc.close();
    }

    private static void displayArray(int[] arr) {
        System.out.print("  [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", "); // Add comma between elements
            }
        }
        System.out.println("]");
    }
}