// To use string and construct it

import java.util.*;

public class _06_String_constructor {
    public static void main(String[] args) {
        String s1 = "Hello, World!";
        // string literal is created in string pool (cache for reusing same string if exists)
        // s1 is reference in stack holding memory address of string object

        char[] c = {'J', 'A', 'V', 'A'};
        String s2 = new String(c);
        // string object created in heap (due to new)
        System.out.println("s2: " + s2);

        String str1 = "Coding";
        char[] arr = {'C','o','d','i','n','g'};
        String str2 = new String(arr);

        // This checks if str1 and str2 point to the same memory address.
        // It will print 'false' because str1 is from the string pool and str2 was explicitly created in the heap.
        System.out.println(str1 == str2);

        // This checks if the actual character sequences are the same.
        // It will print 'true'.
        System.out.println(str1.equals(str2));
    }
}