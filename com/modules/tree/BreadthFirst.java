package tree;

import java.util.LinkedList;

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

public class BreadthFirst {
    public static void main(String args[]) {
        Node root = getSampleTree();
        BreadthFirst breadthFirst = new BreadthFirst();
        breadthFirst.printBfs(root);
    }

    public void printBfs(Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node poppedOut = queue.poll();
            System.out.println(poppedOut.data);
            if (poppedOut.left != null)
                queue.add(poppedOut.left);
            if (poppedOut.right != null)
                queue.add(poppedOut.right);
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
