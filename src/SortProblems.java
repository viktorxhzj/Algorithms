import java.util.Random;

/**
 * LeetCode40
 * 找出其中最小的 k 个数。
 * 思路：QuickSort 下标 k = target 即可。
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
 * 思路：QuickSort 找到下标k-1
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

/**
 * 剑指51
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 思路：Modified MergeSort
 */
class JZ51 {
    public int reversePairs(int[] nums) {
        return mergeSortM(nums, 0, nums.length - 1);
    }

    public int mergeSortM(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int l = mergeSortM(nums, low, mid);
        int r = mergeSortM(nums, mid + 1, high);
        int m = mergeM(nums, low, mid, high);
        return l + r + m;
    }

    public int mergeM(int[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0, count = 0, local = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                count += local;
                temp[k++] = nums[i++];
            }
            else {
                local++;
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            count += local;
            temp[k++] = nums[i++];
        }
        while (j <= high) temp[k++] = nums[j++];
        for (k = 0; k < temp.length; k++) nums[low + k] = temp[k];

        return count;
    }

    public static void main(String[] args) {
        JZ51 test = new JZ51();
        int[] nums = {7, 5, 6, 4};
        int res = test.mergeSortM(nums, 0, 3);
        System.out.println("END");
    }
}