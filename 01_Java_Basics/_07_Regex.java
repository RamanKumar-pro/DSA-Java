// To find the email and check it is on gmail and find domain and username from it.

import java.util.*;

public class _07_Regex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = sc.next();
        if (!email.matches(".*@.*")) {
            System.out.println("Invalid email address");
        }
        else {
            int sep = email.indexOf('@');
            String username = email.substring(0, sep);
            String domain = email.substring(sep + 1);
            System.out.println("Username: " + username);
            System.out.println("Domain: " + domain);
        }

        System.out.print("Enter string: ");
        sc.next(); // clear buffer
        String str = sc.nextLine();
        System.out.println("No of words: " + noOfWords(str));
    }

    private static int noOfWords(String str) {
        return 1 + str.trim().split("\\s+").length;
    }
}