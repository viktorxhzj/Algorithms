package leetcode;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] == target) return mid;
            else right = mid;
        }
        return left;
    }
}

class LC35II {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) return m;
            if (nums[m] < target) i = m + 1;
            if (nums[m] > target) j = m - 1;
        }

        // i = j + 1
        return i;
    }
}
