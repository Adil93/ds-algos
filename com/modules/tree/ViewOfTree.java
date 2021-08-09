package tree;

public class ViewOfTree {

    private int maxLevel = 0;

    public static void main(String args[]) {
        Node root = getSampleTree();
        ViewOfTree leftView = new ViewOfTree();
        System.out.println("Left View");
        leftView.printLeftView(root, 1);
        System.out.println("Right View");
        leftView.maxLevel = 0;
        leftView.printRighView(root, 1);
    }

    public void printLeftView(Node root, int level) {

        if (root != null) {
            if (level > maxLevel) {
                System.out.println(root.data);
                maxLevel = level;
            }
            printLeftView(root.left, level + 1);
            printLeftView(root.right, level + 1);
        }
    }

    public void printRighView(Node root, int level) {

        if (root != null) {
            if (level > maxLevel) {
                System.out.println(root.data);
                maxLevel = level;
            }

            printRighView(root.right, level + 1);
            printRighView(root.left, level + 1);
        }
    }

    private static Node getSampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(9);

        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        return root;
    }
}
