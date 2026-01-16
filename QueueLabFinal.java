public class QueueLabFinal {

    static class QueueArray {
        private int[] arr;
        private int size;
        private int front;
        private int rear;

        public QueueArray(int capacity) {
            arr = new int[capacity];
            size = 0;
            front = 0;
            rear = -1;
        }

        public void enqueue(int value) {
            if (size == arr.length) {
                resize();
            }
            rear++;
            arr[rear] = value;
            size++;
            System.out.println(value + " enqueued");
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int removed = arr[front];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            size--;
            return removed;
        }

        public int peek() {
            if (isEmpty()) return -1;
            return arr[front];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void resize() {
            int newSize = arr.length * 2;
            int[] newArr = new int[newSize];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
            System.out.println("Queue resized to " + newSize);
        }

        public void printQueue() {
            System.out.print("Queue: ");
            for (int i = 0; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public int findMax() {
            if (isEmpty()) return -1;
            int max = arr[front];
            for (int i = front + 1; i <= rear; i++) {
                if (arr[i] > max) max = arr[i];
            }
            return max;
        }

        public int findSum() {
            int sum = 0;
            for (int i = front; i <= rear; i++) sum += arr[i];
            return sum;
        }

        public int countElements() {
            return size;
        }
    }

    static class QueueLinkedList {
        private Node front;
        private Node rear;

        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            System.out.println(value + " enqueued");
        }

        public int dequeue() {
            if (front == null) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int removed = front.data;
            front = front.next;
            if (front == null) rear = null;
            return removed;
        }

        public int peek() {
            if (front == null) return -1;
            return front.data;
        }

        public void printQueue() {
            System.out.print("Queue: ");
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public int findMax() {
            int max = Integer.MIN_VALUE;
            Node temp = front;
            while (temp != null) {
                if (temp.data > max) max = temp.data;
                temp = temp.next;
            }
            return max;
        }

        public int findSum() {
            int sum = 0;
            Node temp = front;
            while (temp != null) {
                sum += temp.data;
                temp = temp.next;
            }
            return sum;
        }

        public int countElements() {
            int count = 0;
            Node temp = front;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {

        System.out.println("---- QUEUE USING ARRAY ----");
        QueueArray qa = new QueueArray(4);
        qa.enqueue(15);
        qa.enqueue(25);
        qa.enqueue(35);
        qa.enqueue(45);
        System.out.println("Removed: " + qa.dequeue());
        qa.enqueue(55);
        qa.enqueue(65);
        qa.enqueue(75); // triggers resize
        qa.printQueue();
        System.out.println("Max element: " + qa.findMax());
        System.out.println("Sum of elements: " + qa.findSum());
        System.out.println("Count of elements: " + qa.countElements());

        System.out.println("\n---- QUEUE USING LINKED LIST ----");
        QueueLinkedList ql = new QueueLinkedList();
        ql.enqueue(8);
        ql.enqueue(16);
        ql.enqueue(24);
        ql.enqueue(32);
        System.out.println("Removed: " + ql.dequeue());
        ql.enqueue(40);
        ql.printQueue();
        System.out.println("Max element: " + ql.findMax());
        System.out.println("Sum of elements: " + ql.findSum());
        System.out.println("Count of elements: " + ql.countElements());
    }
}
