import java.util.Arrays;
public class Sorting {

    public static void mergeSort(int[] arr, int si, int ei) {

        if (si >= ei) return;

        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid);

        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1];
        int idx1 = si, idx2 = mid + 1, x = 0;

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) merged[x++] = arr[idx1++];
            else merged[x++] = arr[idx2++];
        }

        while (idx1 <= mid) merged[x++] = arr[idx1++];

        while (idx2 <= ei) merged[x++] = arr[idx2++];

        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);

            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int idx = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                idx++;
                swap(arr, idx, j);
            }
        }

        idx++;
        swap(arr, idx, high);
        return idx;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr1 = {5, 3, 4, 1};
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.println("Merge Sort Result: " + Arrays.toString(arr1));

        int[] arr2 = {5, 3, 4, 1};
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println("Quick Sort Result: " + Arrays.toString(arr2));
    }
}
