// To implement a Linked List ADT with CRUD Operations

class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private ListNode head;
    private int length;

    public LinkedList() {
        this.head = new ListNode(-1); // dummy sentinel node
        this.length = 0;
    }

    public void insertAtHead(int data) {
        ListNode newNode  = new ListNode(data);
        newNode.next = this.head.next;
        this.head.next = newNode;
        this.length++;
    }

    public void insertAtTail(int data) {
        ListNode temp = this.head;
        for(int i = 0; i < this.length; ++i) temp = temp.next;
        temp.next = new ListNode(data);
        this.length++;
    }

    public void insertAtIndex(int idx, int data) {
        if(idx < 0 || idx > this.length) {
            System.out.println("Invalid index!");
            return;
        }
        ListNode temp = this.head;
        for(int i = 0; i < idx; ++i) temp = temp.next;
        ListNode newNode = new ListNode(data);
        newNode.next = temp.next;
        temp.next = newNode;
        this.length++;
    }

    public void displayList() {
        for(ListNode temp = this.head.next; temp != null; temp = temp.next)
            System.out.print(temp.data + "->");
        System.out.println("null");
    }

    public int getNode(int idx) {
        if(idx < 0 || idx >= this.length) {
            System.out.println("Invalid index!");
            return -1;
        }
        ListNode temp = this.head.next;
        for(int i = 0; i < idx; ++i) temp = temp.next;
        return temp.data;
    }

    public void updateNode(int idx, int data) {
        if(idx < 0 || idx >= this.length) {
            System.out.println("Invalid index!");
            return;
        }

        ListNode temp = this.head.next;
        for(int i = 0; i < idx; ++i) temp = temp.next;
        temp.data = data;
    }

    public int deleteNode(int idx) {
        if(idx < 0 || idx >= this.length) {
            System.out.println("Invalid index!");
            return -1;
        }
        ListNode temp = this.head;
        for(int i = 0; i < idx; ++i) temp = temp.next;
        ListNode node = temp.next;
        int val = node.data;
        temp.next = node.next;
        node.next = null;
        this.length--;
        return val;
    }
}
public class LL_ADT {
    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        LL.insertAtHead(7);
        LL.insertAtTail(9);
        LL.insertAtTail(3);
        LL.displayList(); // Output: 7->9->3->null

        LL.insertAtIndex(2,1);
        LL.insertAtTail(4);
        LL.displayList(); // Output: 7->9->1->3->4->null

        LL.updateNode(4, 12);
        LL.deleteNode(5); // Invalid index!
        LL.displayList(); // Output: 7->9->1->3->12->null
    }
}
