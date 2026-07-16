// ensure all the required .java files are in the same directory
// if they can't be in same directory you import them using "import directory.class_name;" in Main file
// use "javac *.java" to compile all of them
// use "java Main" to run the main file successfully

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        t.insert(3);
        t.insert(4);
        t.insert(2);
        t.insert(6);
        t.insert(8);
        t.inOrderTraversal();
    }
}