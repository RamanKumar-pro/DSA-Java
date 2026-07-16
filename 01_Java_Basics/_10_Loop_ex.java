// To print multiplication table upto 10
// To print sum of number upto n
// To print factorial of number

import java.util.*;

public class _10_Loop_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n for multiplication table: ");
        int n = sc.nextInt();
        for(int i = 1; i <= 10; ++i)
            System.out.println(n + " X " + i + " = " + n * i);

        System.out.print("Enter n for sum of first n natural numbers: ");
        n = sc.nextInt();
        int sum = 0;
        for(int i = 1; i <= n; ++i)
            sum += i;
        System.out.println("Sum = " + sum);

        System.out.print("Enter n for factorial: ");
        n = sc.nextInt();
        int fact = 1;
        for(int i = 1; i <= n; ++i)
            fact *= i;
        System.out.print(n + "! = " + fact);

        sc.close();
    }
}