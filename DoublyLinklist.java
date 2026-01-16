public class DoublyLLLab {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLL {

        Node head, tail;

        public void addFirst(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = tail = newNode;
                return;
            }

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        public void addLast(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        public void printForward() {
            Node temp = head;
            System.out.print("Forward: ");
            while (temp != null) {
                System.out.print(temp.data + " ⇆ ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public void printBackward() {
            Node temp = tail;
            System.out.print("Backward: ");
            while (temp != null) {
                System.out.print(temp.data + " ⇆ ");
                temp = temp.prev;
            }
            System.out.println("null");
        }

        public void deleteFirst() {
            if (head == null) return;
            if (head == tail) {
                head = tail = null;
                return;
            }
            head = head.next;
            head.prev = null;
        }

        public void deleteLast() {
            if (head == null) return;
            if (head == tail) {
                head = tail = null;
                return;
            }
            tail = tail.prev;
            tail.next = null;
        }

        public void deleteByValue(int value) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node temp = head;

            if (temp.data == value) { // Delete head
                head = head.next;
                if (head != null) head.prev = null;
                System.out.println(value + " deleted.");
                return;
            }

            while (temp != null && temp.data != value) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Value not found.");
                return;
            }

            if (temp.next == null) { // Delete tail
                tail = temp.prev;
                tail.next = null;
            } else { // Delete middle node
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }

            System.out.println(value + " deleted.");
        }

        public void deleteAfterValue(int value) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node temp = head;
            while (temp != null && temp.data != value) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Value not found");
                return;
            }

            if (temp.next == null) {
                System.out.println("No next node exists");
                return;
            }

            System.out.println(temp.next.data + " deleted.");

            if (temp.next.next == null) { // Delete tail
                temp.next = null;
                tail = temp;
            } else { // Delete middle
                temp.next = temp.next.next;
                temp.next.prev = temp;
            }
        }

        public void deleteBeforeValue(int value) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node temp = head;
            while (temp != null && temp.data != value) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Value not found");
                return;
            }

            if (temp.prev == null) {
                System.out.println("No previous node exists");
                return;
            }

            System.out.println(temp.prev.data + " deleted.");

            if (temp.prev.prev == null) { // Delete head
                head = temp;
                temp.prev = null;
            } else { // Delete middle
                temp.prev = temp.prev.prev;
                temp.prev.next = temp;
            }
        }

        public void reverseDLL() {
            Node current = head;
            Node temp = null;

            while (current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }

            if (temp != null)
                head = temp.prev;
        }

        public int search(int key) {
            Node temp = head;
            int index = 0;
            while (temp != null) {
                if (temp.data == key) return index;
                temp = temp.next;
                index++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();

        dll.addFirst(35);
        dll.addFirst(15);
        dll.addLast(35);
        dll.printForward();
        dll.printBackward();

        dll.deleteFirst();
        dll.printForward();

        dll.deleteLast();
        dll.printForward();

        dll.addFirst(30);
        dll.addLast(43);
        dll.addLast(54);
        dll.printForward();
        dll.deleteByValue(33);
        dll.printForward();

        dll.deleteAfterValue(350);
        dll.printForward();

        dll.deleteBeforeValue(54);
        dll.printForward();


        dll.reverseDLL();
        dll.printForward();


        int idx = dll.search(40);
        System.out.println("Element 40 found at index: " + idx);
    }
}
