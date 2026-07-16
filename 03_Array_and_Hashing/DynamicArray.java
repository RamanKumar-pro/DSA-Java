public class DynamicArray {
    private int capacity;
    private int size;
    private int[] array;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = new int[capacity];
    }

    public void insert(int val, int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size + 1 >= capacity) {
            int[] newArray = new int[2 * capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            this.array = newArray;
            this.capacity = 2 * capacity;
        }
        for (int i = size; i > idx; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[idx] = val;
        this.size++;
    }

    public void insert(int val) {
        this.insert(val, this.size);
    }

    public void update(int idx, int val) {
        if (idx >= 0 && idx < size) {
            this.array[idx] = val;
        }
    }

    public int remove(int idx) {
        if (idx >= 0 && idx < size) {
            int val = this.array[idx];
            for (int i = idx; i < size - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.size--;
            return val;
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public int get(int idx) {
        if (idx >= 0 && idx < size) {
            return this.array[idx];
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\b]");
    }
}
