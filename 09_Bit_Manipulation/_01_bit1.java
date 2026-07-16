// To learn basic bit concepts

import java.util.*;
import java.lang.*;

public class _01_bit1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        int n;
        System.out.print("Enter n: ");
        n = sc.nextInt();
        System.out.print(convert2binary(n));
         */
        String s = "1101";
        System.out.println("Answer: " + bin2dec(s));
    }

    public static int bin2dec(int n) {
        int res = 0, i = 0;
        while (n > 0) {
            int dig = n % 10;
            res += Math.pow(2, i) * dig;
            i++;
        }
        return res;
    }

    public static int str2int(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); ++i)
            num = 10 * num + (s.charAt(i) - '0');
        return num;
    }

    public static int bin2dec(String n) {
        int num = str2int(n);
        return bin2dec(num);
    }

    public static int convert2binary(int n) {
        int res = 0;
        while (n > 0) {
            int rem = n % 2;
            res = 10 * res + rem;
            n = n / 2;
        }
        int rev = 0;
        while (res > 0) {
            rev = 10 * rev + res % 10;
            res = res / 10;
        }
        return rev;
    }
}
