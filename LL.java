import java.util.*;

public class LL {

    Node head;
    private int size;

    LL() { size = 0; }

    public class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Print list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // 🧹 Custom Function: deleteGreaterThan(limit)
    public void deleteGreaterThan(int limit) {
        while (head != null && head.data > limit) {
            head = head.next;
            size--;
        }

        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data > limit) {
                curr.next = curr.next.next;
                size--;
            } else {
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LL list = new LL();

        System.out.print("Enter size of list: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        System.out.print("\nOriginal List: ");
        list.printList();

        list.deleteGreaterThan(25);

        System.out.print("Updated List (after deleting >25): ");
        list.printList();
    }
}