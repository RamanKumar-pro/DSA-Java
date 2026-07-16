// To construct a calculator program

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Calculator program");

        while (true) {
            printMenu();
            int choice = getUserChoice(sc);

            if (choice == 7) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            performCalculation(choice, sc);
        }
        sc.close();
    }

    public static void printMenu() {
        String ends = "=".repeat(50);
        System.out.println(ends);
        System.out.println("Choice Menu");
        System.out.println(ends);
        System.out.println("1 - Addition");
        System.out.println("2 - Subtraction");
        System.out.println("3 - Multiplication");
        System.out.println("4 - Division");
        System.out.println("5 - Remainder");
        System.out.println("6 - Exponentiation");
        System.out.println("7 - Exit");
    }

    public static int getUserChoice(Scanner sc) {
        System.out.print("Enter your choice: ");
        int choice = -1;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next(); // Clear the invalid input from the scanner
        }
        return choice;
    }

    public static void performCalculation(int choice, Scanner sc) {
        if (choice < 1 || choice > 6) {
            System.out.println("Invalid choice! Please select an option from 1 to 7.");
            return;
        }

        double num1, num2;
        try {
            System.out.print("Enter first number: ");
            num1 = sc.nextDouble();
            System.out.print("Enter second number: ");
            num2 = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid number format. Please enter valid numbers.");
            sc.next(); // Clear the invalid input
            return;
        }

        double result = 0.0;
        boolean calculationSuccessful = true;

        switch (choice) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    calculationSuccessful = false;
                } else {
                    result = num1 / num2;
                }
                break;
            case 5:
                if (num2 == 0) {
                    System.out.println("Error: Cannot find remainder with zero.");
                    calculationSuccessful = false;
                } else {
                    result = num1 % num2;
                }
                break;
            case 6:
                result = Math.pow(num1, num2);
                break;
        }

        if (calculationSuccessful) {
            System.out.printf("Result: %.2f\n", result);
        }
    }
}