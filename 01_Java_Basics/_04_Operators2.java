import java.util.*;

public class _04_Operators2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // find root of quadratic equation
        // ax^2 + bx + c = 0
        double a, b, c;
        System.out.print("Enter coefficient of x^2 term: ");
        a = sc.nextDouble();
        System.out.print("Enter coefficient of x term: ");
        b = sc.nextDouble();
        System.out.print("Enter constant term: ");
        c = sc.nextDouble();

        double det = b * b - 4 * a * c;
        if (det == 0) {
            System.out.println("Roots are real and equal");
            double x = -b / (2 * a);
            System.out.printf("x = %.2f", x);

        }
        else if (det > 0) {
            System.out.println("Roots are real and unequal");
            double x1 = (-b - Math.sqrt(det)) / (2 * a);
            double x2 = (-b + Math.sqrt(det)) / (2 * a);
            System.out.printf("x1 = %.2f, x2 = %.2f", x1, x2);
        }
        else {
            System.out.println("Roots are imaginary");
            double realPart = -b/(2*a);
            double imaginaryPart = Math.sqrt(-det)/(2*a);
            System.out.printf("x = %.2f +- %.2fj", realPart, imaginaryPart);
        }

        sc.close();
    }
}