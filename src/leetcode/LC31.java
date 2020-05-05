package leetcode;

public class LC31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i == -1) {
            int k = 0, m = nums.length - 1;
            while (k < m) {
                swap(nums, k++, m--);
            }
        }
        else {
            int minIndex = i + 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[minIndex] && nums[j] > nums[i]) minIndex = j;
            }
            swap(nums, i, minIndex);
            int k = i + 1, m = nums.length - 1;
            while (k < m) {
                swap(nums, k++, m--);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
