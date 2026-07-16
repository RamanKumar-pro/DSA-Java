// To pass parameter in method

import java.util.*;

// A simple custom class to demonstrate object parameter passing
class MyObject {
    int value;
    MyObject(int v) { this.value = v; }
    @Override
    public String toString() { return "MyObject{value=" + value + "}"; }
}

public class _17_Method_param_pass {

    /**
     * Modifies an element of an array (an object).
     * In Java, objects are passed by value of their reference.
     * This means the method receives a copy of the reference to the array.
     * Modifying the content of the array through this reference affects the original array.
     */
    static void change1(int[] arr, int idx, int val) {
        arr[idx] = val; // Modifies the content of the array object pointed to by 'arr'
    }

    /**
     * Attempts to reassign a primitive parameter.
     * Primitives in Java are always passed by value.
     * The method receives a copy of the primitive's value.
     * Reassigning the parameter 'var' inside the method only affects this local copy,
     * not the original variable in the caller's scope.
     */
    static void change2(int var, int val) {
        var = val; // Reassigns the local copy of the primitive 'var', does not affect the original variable
    }

    /**
     * Attempts to reassign an object reference parameter.
     * Objects in Java are passed by value of their reference.
     * The method receives a copy of the reference to the object.
     * Reassigning the parameter 'obj' inside the method only affects this local copy of the reference,
     * not the original reference variable in the caller's scope.
     */
    static void changeObjectReference(MyObject obj) {
        obj = new MyObject(99); // Reassigns the local copy of the object reference 'obj', does not affect the original reference
    }

    /**
     * Modifies a field of an object passed as a parameter.
     * Objects in Java are passed by value of their reference.
     * The method receives a copy of the reference to the object.
     * Modifying the content (fields) of the object through this reference affects the original object.
     */
    static void modifyObjectField(MyObject obj, int newVal) {
        obj.value = newVal; // Modifies the content of the object pointed to by 'obj'
    }

    public static void main(String[] args) {
        // --- Demonstrating array (object) parameter passing: modifying content ---
        int[] A = {1,2,3,4,5}; // Array is an object
        System.out.println("Original array A: " + Arrays.toString(A));
        change1(A,2,10); // Passed a copy of the object reference; modifying A[2] is visible outside
        System.out.println("After change1 (A[2]=10): " + Arrays.toString(A)); // A[2] is updated to 10

        System.out.println("\n------------------------------------");

        // --- Demonstrating primitive parameter passing: reassigning parameter ---
        int x = 10;
        System.out.println("Original primitive x: " + x);
        change2(x,20); // Passed a copy of the primitive value; reassigning 'var' inside does not affect 'x'
        System.out.println("After change2 (x=20): " + x); // x remains 10

        System.out.println("\n------------------------------------");

        // --- Demonstrating custom object parameter passing: modifying field ---
        MyObject myObj1 = new MyObject(50);
        System.out.println("Original object myObj1: " + myObj1);
        modifyObjectField(myObj1, 75); // Passed a copy of the object reference; modifying myObj1.value is visible outside
        System.out.println("After modifyObjectField (myObj1.value=75): " + myObj1); // myObj1.value is updated to 75

        System.out.println("\n------------------------------------");

        // --- Demonstrating custom object parameter passing: reassigning reference ---
        MyObject myObj2 = new MyObject(100);
        System.out.println("Original object myObj2: " + myObj2);
        changeObjectReference(myObj2); // Passed a copy of the object reference; reassigning 'obj' inside does not affect 'myObj2'
        System.out.println("After changeObjectReference (obj=new MyObject(99)): " + myObj2); // myObj2 remains MyObject{value=100}
    }
}
