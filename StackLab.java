public class StackLab{

    static class StackArray {
        private int[] stack;
        private int top;

        public StackArray(int size) {
            stack = new int[size];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void push(int value) {
            if (top == stack.length - 1) {
                resize();
            }
            stack[++top] = value;
            System.out.println(value + " pushed to stack");
        }

        public int pop() {
            if (isEmpty()) return -1;
            int removed = stack[top--];
            System.out.println(removed + " popped from stack");
            return removed;
        }

        public int peek() {
            if (isEmpty()) return -1;
            return stack[top];
        }

        private void resize() {
            int[] newStack = new int[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
            System.out.println("Stack size doubled to " + stack.length);
        }

        public void printStack() {
            System.out.print("Stack elements: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    static class StackLinkedList {

        private Node top;

        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
            System.out.println(value + " pushed to stack");
        }

        public int pop() {
            if (isEmpty()) return -1;
            int removed = top.data;
            top = top.next;
            System.out.println(removed + " popped from stack");
            return removed;
        }

        public int peek() {
            if (isEmpty()) return -1;
            return top.data;
        }

        public void printStack() {
            System.out.print("Stack elements: ");
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        private void silentPush(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }

        private int silentPop() {
            int value = top.data;
            top = top.next;
            return value;
        }

        public boolean isPalindrome() {
            StackLinkedList copy = new StackLinkedList();
            StackLinkedList temp = new StackLinkedList();

            Node current = top;
            while (current != null) {
                copy.silentPush(current.data);
                temp.silentPush(current.data);
                current = current.next;
            }

            StackLinkedList reversed = temp.reverseStack();

            while (!copy.isEmpty() && !reversed.isEmpty()) {
                if (copy.silentPop() != reversed.silentPop()) {
                    return false;
                }
            }
            return true;
        }

        public StackLinkedList reverseStack() {
            StackLinkedList temp = new StackLinkedList();
            while (!isEmpty()) {
                temp.silentPush(silentPop());
            }
            return temp;
        }
    }

    public static void main(String[] args) {

        System.out.println("---- ARRAY STACK ----");
        StackArray arrStack = new StackArray(3);
        arrStack.push(10);
        arrStack.push(20);
        arrStack.push(30);
        arrStack.push(40); // triggers resize
        arrStack.printStack();

        System.out.println("\n---- LINKED LIST STACK ----");
        StackLinkedList llStack = new StackLinkedList();
        llStack.push(1);
        llStack.push(2);
        llStack.push(3);
        llStack.push(2);
        llStack.push(1);
        llStack.printStack();

        System.out.println("Is Palindrome: " + llStack.isPalindrome());
    }
}
