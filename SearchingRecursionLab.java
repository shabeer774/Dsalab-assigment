public class SearchingRecursionLab {

    public static int linearSearchRec(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }

        return linearSearchRec(arr, target, index + 1);
    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == target) return mid;

        if (target < arr[mid])
            return binarySearchRecursive(arr, low, mid - 1, target);

        return binarySearchRecursive(arr, mid + 1, high, target);
    }

    public static void main(String[] args) {

        int[] arr1 = {5, 12, 7, 25, 3};
        int target1 = 25;

        int resultLinear = linearSearchRec(arr1, target1, 0);

        System.out.println("Recursive Linear Search:");
        if (resultLinear == -1)
            System.out.println("Element not found");
        else
            System.out.println("Found at index: " + resultLinear);

        int[] arr2 = {2, 4, 6, 8, 10, 12, 14}; // must be sorted
        int target2 = 8;

        int resultBinary = binarySearchRecursive(arr2, 0, arr2.length - 1, target2);

        System.out.println("\nRecursive Binary Search:");
        if (resultBinary == -1)
            System.out.println("Element not found");
        else
            System.out.println("Found at index: " + resultBinary);
    }
}
