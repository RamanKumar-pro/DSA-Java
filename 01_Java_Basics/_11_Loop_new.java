// To find digits of number
// Count digits
// armstrong number
// reverse a number
// check number is palindrome

import java.util.InputMismatchException;
import java.util.Scanner;

public class _11_Loop_new {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1 - Display digits of number");
            System.out.println("2 - Count digits");
            System.out.println("3 - Check for armstrong number");
            System.out.println("4 - Reverse number");
            System.out.println("5 - Check for palindrome");
            System.out.println("6 - Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();

                if (choice == 6) {
                    System.out.println("Thank You");
                    break;
                }

                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    continue;
                }

                System.out.print("Enter an integer: ");
                int n = sc.nextInt();

                switch (choice) {
                    case 1:
                        printDigits(n);
                        break;
                    case 2:
                        System.out.println("Number of digits: " + countDigits(n));
                        break;
                    case 3:
                        if (isArmstrong(n))
                            System.out.println(n + " is an Armstrong Number.");
                        else
                            System.out.println(n + " is not an Armstrong Number.");
                        break;
                    case 4:
                        System.out.println("Reversed: " + reverseNumber(n));
                        break;
                    case 5:
                        if (isPalindrome(n))
                            System.out.println(n + " is a palindrome.");
                        else
                            System.out.println(n + " is not a palindrome.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                sc.next(); // Clear the invalid input from the scanner
            }
        }
        sc.close();
    }

    private static void printDigits(int n) {
        if (n == 0) {
            System.out.println("0");
            return;
        }
        if (n < 0) {
            System.out.print("- ");
            n = Math.abs(n);
        }
        
        long reversed = 0;
        int tempN = n;
        while (tempN > 0) {
            reversed = reversed * 10 + (tempN % 10);
            tempN /= 10;
        }
        
        while (reversed > 0) {
            System.out.print(reversed % 10 + " ");
            reversed /= 10;
        }
        tempN = n;
        while (tempN > 0 && tempN % 10 == 0) {
            System.out.print("0 ");
            tempN /= 10;
        }
        System.out.println();
    }

    private static int countDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int count = 0;
        long tempN = Math.abs((long)n);
        while (tempN > 0) {
            tempN /= 10;
            count++;
        }
        return count;
    }

    private static boolean isArmstrong(int n) {
        if (n < 0) {
            return false;
        }
        int numDigits = countDigits(n);
        long sum = 0;
        int tempN = n;
        while (tempN > 0) {
            int digit = tempN % 10;
            sum += Math.pow(digit, numDigits);
            tempN /= 10;
        }
        return sum == n;
    }

    private static int reverseNumber(int n) {
        long reversed = 0;
        int tempN = n;
        while (tempN != 0) {
            reversed = reversed * 10 + (tempN % 10);
            tempN /= 10;
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            System.out.println("Warning: Reversed number caused an integer overflow.");
            return 0; 
        }
        return (int) reversed;
    }

    private static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        return reverseNumber(n) == n;
    }
}