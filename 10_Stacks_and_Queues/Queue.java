public class Queue {
    private int n;
    private int[] array;
    private int front;
    private int rear;


    public Queue(int n) {
        this.n = n;
        this.array = new int[n];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int x) {
        if (overflow()) {
            throw new RuntimeException("Queue Overflow!");
        }

    }

    public int dequeue() {
        if underflow() {
            throw new RuntimeException("Queue Underflow!");
        }

    }

    public boolean underflow() {
        return front == -1;
    }

    public boolean overflow() {
        return (rear + 1) % n == front;
    }
}
