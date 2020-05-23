package algorithms;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
    public static int partition(int[] arr, int left, int right) {
        int pivotNum = arr[right];

        while (left < right) {
            while (left < right && arr[left] < pivotNum) left++;
            arr[right] = arr[left];
            while (left < right && arr[right] >= pivotNum) right--;
            arr[left] = arr[right];
        }
        arr[left] = pivotNum;
        return left;
    }
}
