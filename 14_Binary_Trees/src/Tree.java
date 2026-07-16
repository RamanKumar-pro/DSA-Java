import java.util.*;

public class Tree {
    public static class Node {
        public int data;
        public Node leftchild;
        public Node rightchild;

        public Node(int val) {
            this.data = val;
        }
    }
    public Node root;

    // insertion is like a BST
    public void insert(int val) {
        if(root == null) {
            root = new Node(val);
            return;
        }
        Node curr = root;
        while(true) {
            if(curr.data > val) {
                if(curr.leftchild == null) {
                    curr.leftchild = new Node(val);
                    return;
                }
                curr = curr.leftchild;
            }
            else if(curr.data < val){
                if(curr.rightchild == null) {
                    curr.rightchild = new Node(val);
                    return;
                }
                curr = curr.rightchild;
            }
            else {
                System.out.println("Value " + val + " already exists in the tree");
                return;
            }
        }
    }

    public Node insertRecursive(Node root, int val) {
        if(root == null)
            return new Node(val);

        if(root.data > val)
            root.leftchild = insertRecursive(root.leftchild,val);
        else
            root.rightchild = insertRecursive(root.rightchild,val);
        return root;
    }

    public boolean find(int val) {
        if(root == null) return false;
        Node curr = root;
        while(true) {
            if(curr.data == val) return true;
            else if(curr.data < val) {
                if(curr.rightchild == null) return false;
                curr = curr.rightchild;
            }
            else {
                if(curr.leftchild == null) return false;
                curr = curr.leftchild;
            }
        }
    }

    public void preOrderTraversal(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.leftchild);
        preOrderTraversal(root.rightchild);
    }

    /*
    public void preOrderIterative(Node root) {
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr.leftchild != null ^ curr.rightchild != null) {
            int val;
            if(curr.leftchild != null) {
                curr = curr.leftchild;
                val = curr.data;
            }
            else {
                curr = curr.rightchild;
                val = curr.data;
            }
            System.out.print(val+" ");
        }
        if(curr.leftchild == null)
            return;
        do {
            if(curr.rightchild != null) st.push(curr.rightchild);
            System.out.print(curr.leftchild.data + " ");
            if(curr.leftchild == null) {
                curr = st.poll();
            }
        } while(!st.isEmpty());
    }
    */

    public void inOrderTraversal(Node root) {
        if(root == null) return;
        inOrderTraversal(root.leftchild);
        System.out.print(root.data + " ");
        inOrderTraversal(root.rightchild);
    }

    public void postOrderTraversal(Node root) {
        if(root == null) return;
        postOrderTraversal(root.leftchild);
        postOrderTraversal(root.rightchild);
        System.out.print(root.data + " ");
    }

    public void levelOrderTraversal() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data+" ");
            if(curr.leftchild != null)
                q.add(curr.leftchild);
            if(curr.rightchild != null)
                q.add(curr.rightchild);
        }
    }

    public int depthOfTree(Node root) {
        if(root == null) return -1;
        return 1 + Math.max(depthOfTree(root.leftchild),depthOfTree(root.rightchild));
    }
    
    public int heightOfTree(Node root) {
        if(root == null) return -1;
        return Math.max(depthOfTree(root.leftchild),depthOfTree(root.rightchild)) + 1;
    }

    public boolean isLeaf(Node treenode) {
        return treenode.leftchild == null && treenode.rightchild == null;
    }

    // assuming BST so return leftmost leaf
    public int minValue() {
        if(root == null) return -1;
        Node curr = root;
        Node last = curr;
        while(curr != null) {
            last = curr;
            curr = curr.leftchild;
        }
        return last.data;
    }

    public int noOfElements(Node rt) {
        if(rt == null) return 0;
        return 1 + noOfElements(rt.leftchild) + noOfElements(rt.rightchild);
    }

    // finds the largest value in the subtree of given node as root
    private Node findMax(Node n) {
        if(n == null) return null;
        Node temp = n;
        while(temp.rightchild != null) temp = temp.rightchild;
        return temp;
    }

    public Node removeNode(Node n, int val) {
        Node curr;
        if(n == null) return n;
        if(n.data > val)
            n.leftchild = removeNode(n.leftchild,val);
        else if(n.data < val)
            n.rightchild = removeNode(n.rightchild,val);
        else {
            // found node
            // two child case
            if(n.leftchild != null && n.rightchild != null) {
                curr = findMax(n.leftchild);
                n.data = curr.data;
                n.leftchild = removeNode(n.leftchild,n.data);
            }
            else {
                // one or no child case
                curr = n;
                if(n.leftchild == null)
                    n = n.rightchild;
                else n = n.leftchild;
            }
        }
        return n;
    }

    public boolean equals(Node other_root) {
        if(other_root == null) return false;
        return equals(root,other_root);
    }

    private boolean equals(Node r1, Node r2) {
        if(r1 == null && r2 == null) return true;
        else if(r1 != null && r2 != null) {
            return r1.data == r2.data && equals(r1.leftchild,r2.leftchild) && equals(r1.rightchild,r2.rightchild);
        }
        return false;
    }

    public boolean isValidBST() {
        return validNode(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean validNode(Node root, int k1, int k2) {
        if(root == null) return true;
        if(root.data <= k1 || root.data >= k2) return false;
        return validNode(root.leftchild,k1,root.data) && validNode(root.rightchild,root.data,k2);
    }

    public ArrayList<Integer> NodesKthDistance(int k) {
        ArrayList<Integer> res = new ArrayList<>();
        NodesKthDistance(root,k,res);
        return res;
    }

    private void NodesKthDistance(Node root, int k, ArrayList<Integer> ans) {
        if(root == null || k < 0) return;
        if(root.leftchild != null)
            NodesKthDistance(root.leftchild,k-1,ans);
        if(k == 0)
            ans.add(root.data);
        if(root.rightchild != null)
            NodesKthDistance(root.rightchild,k-1,ans);
    }

    public void emptyTree() {

    }

    public void copyTree() {

    }

    // to swap left and right subtrees of all nodes.
    public void swap_SubTrees() {

    }
}
