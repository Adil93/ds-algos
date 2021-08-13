package linkedlist;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    Node head;

    public static void main(String args[]) {
        System.out.println("Inserting at End");
        LinkedList linkedList1 = new LinkedList().insertEnd(1).insertEnd(2).insertEnd(3).insertEnd(4).insertEnd(5);
        linkedList1.printLinkedList();

        System.out.println("\nInserting at front");
        LinkedList linkedList = new LinkedList().insertFront(5).insertFront(4).insertFront(3).insertFront(2)
                .insertFront(1);
        linkedList.printLinkedList();

        System.out.println("Reversing Linked List");
        linkedList.head = reverseLinkedlist(linkedList.head);
        linkedList.printLinkedList();

        System.out.println("Remove n th node from linked list");
        LinkedList remov = new LinkedList().insertFront(1).insertFront(2).insertFront(3).insertFront(4);
        remov.head = removeNode(remov.head, 4);
        remov.printLinkedList();
    }

    public LinkedList insertEnd(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return this;
        }
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return this;
    }

    public LinkedList insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return this;
    }

    public void printLinkedList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void printLinkedListFromHead(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static Node reverseLinkedlist(Node head) {
        if (head == null || head.next == null)
            return head;

        Node p = reverseLinkedlist(head.next);

        head.next.next = head;
        head.next = null;

        return p;
    }

    public static int getLength(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static Node removeNode(Node head, int n) {
        Node temp = head;

        if (n == 1) {
            head = head.next;
            temp = null;
            return head;
        }
        while (n - 2 > 0 && temp != null) {
            temp = temp.next;
            n--;
        }
        if (temp == null || temp.next == null)
            return head;

        Node delElem = temp.next;
        temp.next = temp.next.next;
        delElem.next = null;

        return head;
    }

}
