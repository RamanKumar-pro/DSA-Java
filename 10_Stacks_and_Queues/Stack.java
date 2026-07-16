public class Stack {
    private int n;
    private int top;
    private int[] array;

    public Stack(int n) {
        this.n = n;
        this.array = new int[n];
        this.top = -1;
    }

    public boolean underflow() {
        return this.top == -1;
    }

    public boolean overflow() {
        return this.top == this.n - 1;
    }

    public int peek() {
        if (underflow()) {
            throw new RuntimeException("Stack underflow");
        }
        return this.array[this.top];
    }

    public int pop() {
        if (underflow()) {
            throw new RuntimeException("Stack underflow");
        }
        int x = this.array[this.top];
        this.top--;
        return x;
    }

    public void push(int x) {
        if (overflow()) {
            throw new RuntimeException("Stack overflow");
        }
        this.top++;
        this.array[this.top] = x;
    }
}