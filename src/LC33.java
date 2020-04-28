public class LC33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {

            // left <= mid < right
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // nums[mid]不可能和nums[right]相等

            // [left, mid]递增
            if (nums[mid] > nums[right]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            // [mid, right]递增
            else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return nums[left] == target? left: -1;
    }
}
