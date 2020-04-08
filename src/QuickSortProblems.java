import java.util.Random;

/**
 * LeetCode40
 * 找出其中最小的 k 个数。
 * 思路：快排下标 k = target 即可。
 */
class LC40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSelect(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void quickSelect(int[] array, int low, int high, int target) {
        if (low < high) {
            int pivot = partition(array, low, high);
            if (target == pivot) return ;
            else if (target < pivot) quickSelect(array, low, pivot - 1, target);
            else quickSelect(array, pivot + 1, high, target);
        }

    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}

/**
 * LeetCode215
 * 在未排序的数组中找到第 k 个最大的元素。
 * 思路：找到下标k-1
 */
class LC215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivot = partition(arr, low, high);
            if (pivot == k - 1) return arr[pivot];
            else if (pivot > k - 1) return quickSelect(arr, low, pivot - 1, k);
            else return quickSelect(arr, pivot + 1, high, k);
        }
        return -1;
    }

    public int partition(int[] arr, int low, int high) {
        Random rand = new Random();
        int r = low + rand.nextInt(high - low + 1);
        int temp = arr[low];
        arr[low] = arr[r];
        arr[r] = temp;
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] <= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] >= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}