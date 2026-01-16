import java.util.Scanner;

//class MyArray {
//    private int[] items;
//    private int count;
//
//    public MyArray(int length) {
//        items = new int[length];
//    }
//
//    public void insert(int value) {
//        if (count == items.length) {
//            System.out.println("Array is full! Cannot insert " + value);
//            return;
//        }
//        items[count++] = value;
//    }
//
//    public void print() {
//        for (int i = 0; i < count; i++)
//            System.out.print(items[i] + " ");
//        System.out.println();
//    }
//}
//class DynamicArray {
//    private int[] items;
//    private int count;
//
//    public DynamicArray(int length) {
//        items = new int[length];
//    }
//
//    public void insert(int value) {
//        // if full, resize
//        if (count == items.length) {
//            int[] newItems = new int[count * 2];
//            for (int i = 0; i < count; i++)
//                newItems[i] = items[i];
//            items = newItems;
//            System.out.println("Array resized to " + items.length);
//        }
//        items[count++] = value;
//    }
//
//    public void print() {
//        for (int i = 0; i < count; i++)
//            System.out.print(items[i] + " ");
//        System.out.println();
//    }
//    public void removeAt(int index) {
//        if (index < 0 || index >= count) {
//            System.out.println("Invalid index!");
//            return;
//        }
//        for (int i = index; i < count - 1; i++)
//            items[i] = items[i + 1];
//        count--;
//    }
//
//}


//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter size: ");
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("Enter element " + (i + 1) + ": ");
//            arr[i] = sc.nextInt();
//        }
//
//        int sum = 0, max = arr[0], index = 0;
//        for (int i = 0; i < n; i++) {
//            sum += arr[i];
//            if (arr[i] > max) {
//                max = arr[i];
//                index = i;
//            }
//        }
//
//        double avg = (double) sum / n;
//        System.out.println("Sum = " + sum);
//        System.out.println("Average = " + avg);
//        System.out.println("Max = " + max + " at index " + index);
//        System.out.println("Time Complexity: O(n)");
//        System.out.println("Space Complexity: O(n)");
//        MyArray numbers = new MyArray(3);
//        numbers.insert(11);
//        numbers.insert(22);
//        numbers.insert(33);
//        numbers.insert(23); // full
//        numbers.print();
//        DynamicArray numbers = new DynamicArray(2);
//        numbers.insert(11);
//        numbers.insert(22);
//        numbers.insert(33); // triggers resize
//        numbers.insert(44);
//        numbers.print();
//        numbers.removeAt(3);
//        System.out.println("Value at index 3 is deleted");
//        numbers.print();
    }
}