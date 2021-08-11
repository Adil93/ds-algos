package linkedlist;

public class MergeLinkedList {

    Node mergedHeadNode;

    public static void main(String args[]) {
        LinkedList list1 = new LinkedList().insertFront(7).insertFront(6).insertFront(3).insertFront(1);
        LinkedList list2 = new LinkedList().insertFront(9).insertFront(4).insertFront(2).insertFront(0);

        MergeLinkedList mergeLinkedList = new MergeLinkedList();
        Node mergedHeadNode = mergeLinkedList.merge(list1.head, list2.head);
        LinkedList.printLinkedListFromHead(mergedHeadNode);
    }

    // Merge 2 sorted linked list
    public Node merge(Node head1, Node head2) {

        Node temp1 = head1;
        Node temp2 = head2;
        Node mergedHeadNode = null;

        while (temp1 != null && temp2 != null) {
            if (temp1.data > temp2.data) {
                mergedHeadNode = appendToNode(mergedHeadNode, temp2.data);
                temp2 = temp2.next;
            } else {
                mergedHeadNode = appendToNode(mergedHeadNode, temp1.data);
                temp1 = temp1.next;
            }
        }

        while (temp1 != null) {
            mergedHeadNode = appendToNode(mergedHeadNode, temp1.data);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            mergedHeadNode = appendToNode(mergedHeadNode, temp2.data);
            temp2 = temp2.next;
        }

        return this.mergedHeadNode;
    }

    private Node appendToNode(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            this.mergedHeadNode = head;
            return head;
        }
        head.next = newNode;
        return head.next;
    }
}
