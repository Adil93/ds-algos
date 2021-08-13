package tree.dfs;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeTraversal {

    public static void main(String args[]) {
        Node root = getSampleTree();
        TreeTraversal traversal = new TreeTraversal();

        // LDR
        System.out.println("In Order Traversal");
        traversal.printInOrder(root);

        // DLR
        System.out.println("Pre Order Traversal");
        traversal.printPreOrder(root);

        // LRD
        System.out.println("Post Order Traversal");
        traversal.printPostOrder(root);
    }

    public void printInOrder(Node root) {

        if (root != null) {
            printInOrder(root.left);
            System.out.println(root.data);
            printInOrder(root.right);
        }
    }

    public void printPreOrder(Node root) {

        if (root != null) {
            System.out.println(root.data);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    public void printPostOrder(Node root) {

        if (root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.println(root.data);
        }
    }

    private static Node getSampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

}
