public class AVLTree {
    public AVLNode root;
    private class AVLNode {
        private int data;
        private int height;
        private int balanceFactor;
        private AVLNode leftchild;
        private AVLNode rightchild;

        public AVLNode(Integer val) {
            data = val;
            height = 0;
            balanceFactor = 0;
            leftchild = null;
            rightchild = null;
        }

        @Override
        public String toString() {
            return "Value: " + this.data;
        }

    }

    public AVLTree() {
        root = null;
    }

    public void insert(int val) {
        root = insert(root,val);
    }

    private AVLNode insert(AVLNode root, int val) {
        if(root == null)
            return new AVLNode(val);
        if(root.data > val)
            root.leftchild = insert(root.leftchild,val);
        else
            root.rightchild = insert(root.rightchild,val);
        // updates height of all visited nodes
        root.height = Math.max(height(root.leftchild),height(root.rightchild))+1;
        root.balanceFactor = height(root.leftchild)-height(root.rightchild);
        return root;
    }

    private int height(AVLNode n) {
        return n == null ? -1 : n.height;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(AVLNode n) {
        if(n == null) return;
        inOrderTraversal(n.leftchild);
        System.out.print(n.data + " ");
        inOrderTraversal(n.rightchild);
    }
}
