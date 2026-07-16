// To test recursion/ backtracking

import java.util.ArrayList;
import java.util.Arrays;

public class _16_Recursion {
    public static void main(String[] args) {
//        printName("Raman", 10);
//        printNum(10);
//        System.out.println(findSum(100));
//        System.out.println(fact(6));
        int[] A = {5, 2, 8, 1, 9, 4};
//        displayArray(A);
//        revArrayRec1(A, 0);
//        displayArray(A);
//        String s = "racecar";
//        System.out.println(isPalindrome(s, 0));
//        for (int i = 0; i <= 10; ++i)
//            System.out.print(fib(i) + " ");
//        printSubsequences(A, 0, new ArrayList<> ());
//        int total = 0;
//        for(Integer num: A)
//            total += num;
//        printSubseqWithSumK(A, 0, 2, total, new ArrayList<Integer> ());
//        System.out.println(countSubseqWithSumK(A, 0, 2));
        System.out.println("Original Array: " + Arrays.toString(A));
//        mergeSort(A, 0, A.length - 1);
        quickSort(A, 0, A.length - 1);
        System.out.println("Sorted Array:   " + Arrays.toString(A));
    }

    static void printName(String name, int n) {
        if(n == 0)
            return;
        System.out.println(name);
        printName(name, n-1);
    }

    static void printNum(int n) {
        if (n == 0)
            return;
//        System.out.println(n); // print in reverse order n to 1
        printNum(n-1);
        System.out.println(n); // print from 1 to n
    }

    static int findSum(int n) {
        if (n == 0)
            return 0;
        return n + findSum(n-1);
    }

    static int fact(int n) {
        if(n == 0)
            return 1;
        return n * fact(n-1);
    }

    static void revArrayRec1(int[] arr, int i) {
        if (i == arr.length)
            return;
        revArrayRec1(arr, i+1); // arr[i+1 ... n] is reversed
        // place the arr[i] at the last position
        int temp = arr[i];
        int j = i + 1;
        while (j < arr.length) {
            arr[j - 1] = arr[j];
            j++;
        }
        arr[arr.length - 1] = temp;
    }

    static void revArrayRec2(int[] arr, int i) {
        if (i >= arr.length/2)
            return;
        int j = arr.length - i - 1;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        revArrayRec2(arr, i + 1);
    }

    static void displayArray(int[] arr) {
        System.out.print("Array: [");
        for(int x: arr)
            System.out.print(x + " ");
        System.out.println("\b]");
    }

    static boolean isPalindrome(String s, int i) {
        if (i >= s.length()/2)
            return true;
        if (s.charAt(i) == s.charAt(s.length() - i - 1))
            return isPalindrome(s, i + 1);
        else
            return false;
    }

    static int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        int first = fib(n-1);
        int second = fib(n-2);
        return first + second;
    }

    static void printSubsequences(int[] arr, int i, ArrayList<Integer> curr) {
        if (i >= arr.length) {
            System.out.println(curr);
            return;
        }
//        printSubsequences(arr, i + 1, curr);
        curr.add(arr[i]);
        printSubsequences(arr, i + 1, curr);
        curr.remove(curr.size() - 1);
        printSubsequences(arr, i + 1, curr);
    }

    static void printSubseqWithSumK(int[] arr, int i, int k, int rem, ArrayList<Integer> curr) {
        if (k == 0) {
            System.out.println(curr);
            return;
        }
        if (k < 0 || rem < k || i == arr.length)
            return;
        curr.add(arr[i]);
        printSubseqWithSumK(arr, i + 1, k - arr[i], rem - arr[i], curr);
        curr.remove(curr.size() - 1);
        printSubseqWithSumK(arr, i + 1, k, rem - arr[i], curr);
    }

    static int countSubseqWithSumK(int[] arr, int i, int k) {
        if (k == 0)
            return 1;
        if (k < 0 || i == arr.length)
            return 0;
        return countSubseqWithSumK(arr, i + 1, k - arr[i]) + countSubseqWithSumK(arr, i + 1, k);
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    static void merge(int[] arr, int l, int mid, int r) {
        int m = mid - l + 1;
        int n = r - mid;

        int[] left = new int[m];
        int[] right = new int[n];

        for (int p = 0; p < m; ++p)
            left[p] = arr[l + p];
        for (int q = 0; q < n; ++q)
            right[q] = arr[mid + 1 + q];

        int i = 0;
        int j = 0;
        int k = l;

        while (i < m || j < n) {
            if (j == n || (i < m && left[i] <= right[j]))
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
    }

    static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int pivot = partition(arr, l, r); // places pivot at correct pos and left half is less and right half is more
        quickSort(arr, l, pivot - 1);
        quickSort(arr, pivot + 1, r);
    }

    static int partition(int[] arr, int l, int r) {
        // move two pointer from both end if mismatch swap and move it
        int pivot = arr[r];
        int j = l - 1;
        for(int i = l; i < r; ++i) {
            if (arr[i] <= pivot) {
                int temp = arr[++j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[j + 1];
        arr[j + 1] = arr[r];
        arr[r] = temp;
        return j + 1;
    }
}