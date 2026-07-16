public class Array_ADT {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(5);
        arr.insert(10, 0);
        arr.insert(20);
        arr.insert(30, 2);
        arr.display();
        System.out.println(arr.get(1)); // Output: 20
        arr.update(1, 25);
        System.out.println(arr.get(1)); // Output: 25
        arr.display();
        System.out.println(arr.remove(1)); // Output: 25
        arr.display();
        arr.insert(40, 1);
        arr.insert(50);
        arr.display();
    }
}