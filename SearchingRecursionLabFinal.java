public class SearchingRecursionLabFinal {

    // Linear Search (Iterative)
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    // Linear Search (Recursive)
    public static int linearSearchRecursive(int[] arr, int key, int idx) {
        if (idx >= arr.length) return -1;
        if (arr[idx] == key) return idx;
        return linearSearchRecursive(arr, key, idx + 1);
    }

    // Binary Search (Iterative)
    public static int binarySearch(int[] arr, int key) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) return mid;
            if (key > arr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    // Binary Search (Recursive)
    public static int binarySearchRec(int[] arr, int start, int end, int key) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == key) return mid;
        if (key < arr[mid])
            return binarySearchRec(arr, start, mid - 1, key);
        return binarySearchRec(arr, mid + 1, end, key);
    }

    // Factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Sum of array elements
    public static int arraySum(int[] arr, int i) {
        if (i == arr.length) return 0;
        return arr[i] + arraySum(arr, i + 1);
    }

    // Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Print numbers 1 to N
    public static void printAscending(int n) {
        if (n == 0) return;
        printAscending(n - 1);
        System.out.print(n + " ");
    }

    // Print numbers N to 1
    public static void printDescending(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printDescending(n - 1);
    }

    // Count digits
    public static int digitCount(int n) {
        if (n == 0) return 0;
        return 1 + digitCount(n / 10);
    }

    // Check sorted array
    public static boolean checkSorted(int[] arr, int i) {
        if (i == arr.length - 1) return true;
        return arr[i] <= arr[i + 1] && checkSorted(arr, i + 1);
    }

    // First occurrence
    public static int firstIndex(int[] arr, int key, int i) {
        if (i == arr.length) return -1;
        if (arr[i] == key) return i;
        return firstIndex(arr, key, i + 1);
    }

    // Last occurrence
    public static int lastIndex(int[] arr, int key, int i) {
        if (i == arr.length) return -1;
        int found = lastIndex(arr, key, i + 1);
        if (found != -1) return found;
        return arr[i] == key ? i : -1;
    }

    // Sum of digits
    public static int digitsSum(int n) {
        if (n == 0) return 0;
        return (n % 10) + digitsSum(n / 10);
    }

    // Power calculation
    public static int power(int base, int exp) {
        if (exp == 0) return 1;
        return base * power(base, exp - 1);
    }

    public static void main(String[] args) {

        System.out.println("---- LINEAR SEARCH ----");
        int[] a1 = {7, 14, 28, 9, 3};
        System.out.println("Result index: " + linearSearch(a1, 28));

        System.out.println("\n---- LINEAR SEARCH (RECURSIVE) ----");
        int[] a2 = {4, 11, 19, 27, 33};
        System.out.println("Result index: " +
                linearSearchRecursive(a2, 27, 0));

        System.out.println("\n---- BINARY SEARCH ----");
        int[] sorted = {5, 10, 15, 20, 25, 30};
        System.out.println("Result index: " + binarySearch(sorted, 20));

        System.out.println("\n---- BINARY SEARCH (RECURSIVE) ----");
        System.out.println("Result index: " +
                binarySearchRec(sorted, 0, sorted.length - 1, 20));

        System.out.println("\n---- RECURSION TASKS ----");
        System.out.println("Factorial of 6: " + factorial(6));
        int[] a3 = {2, 4, 6, 8};
        System.out.println("Array sum: " + arraySum(a3, 0));
        System.out.println("Fibonacci(7): " + fibonacci(7));

        System.out.print("1 to 6: ");
        printAscending(6);
        System.out.println();

        System.out.print("6 to 1: ");
        printDescending(6);
        System.out.println();

        System.out.println("Digit count of 98765: " + digitCount(98765));

        int[] a4 = {1, 2, 4, 6, 8};
        System.out.println("Is sorted? " + checkSorted(a4, 0));

        int[] a5 = {2, 5, 5, 7, 5};
        System.out.println("First index of 5: " + firstIndex(a5, 5, 0));
        System.out.println("Last index of 5: " + lastIndex(a5, 5, 0));

        System.out.println("Digits sum of 789: " + digitsSum(789));
        System.out.println("3^4: " + power(3, 4));
    }
}
