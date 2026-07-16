// To test method overriding

class Super {
    int x = 10;
    void display() {
        System.out.println("Super display");
    }
}

class Sub extends Super {
    int x = 20;
    @Override
    void display() {
        System.out.println("Sub display");
    }
}

public class _21_Method_Overriding {
    public static void main(String[] args) {
        Super sup = new Super();
        sup.display();
        System.out.println("sup.x: " + sup.x);

        Sub sub = new Sub();
        sub.display();
        System.out.println("sub.x (from Sub class): " + sub.x);

        System.out.println("sub.x (from Super class): " + ((Super) sub).x);

        Super supRef = new Sub();
        supRef.display();
        System.out.println("supRef.x: " + supRef.x);
        System.out.println("((Sub) supRef).x: " + ((Sub) supRef).x);
    }
}
