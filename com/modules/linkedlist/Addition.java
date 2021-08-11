package linkedlist;

public class Addition {

    int carry = 0;
    LinkedList sum = new LinkedList();

    public static void main(String args[]) {
        LinkedList list1 = new LinkedList().insertFront(1).insertFront(9).insertFront(8);
        LinkedList list2 = new LinkedList().insertFront(2).insertFront(7).insertFront(8).insertFront(9).insertFront(9);

        System.out.println("Adding 2 linked list Recursively");
        Addition addition = new Addition();
        addition.addRecursive(list1.head, list2.head).printLinkedList();
        System.out.println("Adding 2 linked list");
        addition.add(list1.head, list2.head).printLinkedList();
    }

    public LinkedList add(Node head1, Node head2) {
        LinkedList sumList = new LinkedList();
        Node reverseHead1 = LinkedList.reverseLinkedlist(head1);
        Node reverseHead2 = LinkedList.reverseLinkedlist(head2);

        int carry = 0;
        while (reverseHead1 != null && reverseHead2 != null) {
            int sum = reverseHead1.data + reverseHead2.data + carry;
            int data = sum % 10;
            carry = sum / 10;
            sumList.insertFront(data);
            reverseHead1 = reverseHead1.next;
            reverseHead2 = reverseHead2.next;
        }

        while (reverseHead1 != null) {
            int sum = carry + reverseHead1.data;
            int data = sum % 10;
            carry = sum / 10;
            sumList.insertFront(data);
            reverseHead1 = reverseHead1.next;
        }

        while (reverseHead2 != null) {
            int sum = carry + reverseHead2.data;
            int data = sum % 10;
            carry = sum / 10;
            sumList.insertFront(data);
            reverseHead2 = reverseHead2.next;
        }

        if (carry > 0)
            sumList.insertFront(carry);

        return sumList;
    }

    public LinkedList addRecursive(Node head1, Node head2) {
        Node temp1 = head1, temp2 = head2;

        int head1Count = LinkedList.getLength(temp1);
        int head2Count = LinkedList.getLength(temp2);

        Node bigHead, smallHead;

        if (head1Count > head2Count) {
            bigHead = head1;
            smallHead = head2;
        } else {
            bigHead = head2;
            smallHead = head1;
        }

        int difference = Math.abs(head1Count - head2Count);

        Node tempBigHead = bigHead;
        while (difference > 0) {
            tempBigHead = tempBigHead.next;
            difference--;
        }

        addSubRecursive(tempBigHead, smallHead);

        Node tempBigHead1 = bigHead;

        addWithCarryRecursive(tempBigHead1, tempBigHead);

        if (this.carry > 0)
            this.sum.insertFront(carry);
        return this.sum;
    }

    public Node addSubRecursive(Node head1, Node head2) {
        if (head1 != null && head2 != null) {

            addSubRecursive(head1.next, head2.next);

            int sum = this.carry + head1.data + head2.data;
            int data = sum % 10;
            this.carry = sum / 10;
            this.sum.insertFront(data);

            return this.sum.head;
        }

        return null;
    }

    public Node addWithCarryRecursive(Node fromHead, Node toHead) {
        if (fromHead != toHead) {
            addWithCarryRecursive(fromHead.next, toHead);
            int sum = this.carry + fromHead.data;
            int data = sum % 10;
            this.carry = sum / 10;
            this.sum.insertFront(data);

            return this.sum.head;
        }
        return null;
    }

}
