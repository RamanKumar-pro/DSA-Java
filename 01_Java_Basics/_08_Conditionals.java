// To find protocol and type of site

import java.util.*;

public class _08_Conditionals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter website: ");
//        String url = sc.next();
        String url = "https://www.google.com";
        String protocol = url.substring(0, url.indexOf(':'));
        if (protocol.equals("https")) {
            System.out.println("Hyper Text Transfer Protocol");
        }
        else if(protocol.equals("ftp")) {
            System.out.println("File Transfer Protocol");
        }

        String type = url.substring(url.lastIndexOf('.') + 1);
        if (type.equals("com")) {
            System.out.println("Commercial");
        }
        else if (type.equals("org")) {
            System.out.println("Organization");
        }
        else if (type.equals("net")) {
            System.out.println("Network");
        }

        sc.close();
    }
}