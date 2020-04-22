public class LC704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            // target在[left, mid - 1]
            if (target < nums[mid]) right = mid - 1;

            // target在[mid + 1, right]
            if (target > nums[mid]) left = mid + 1;

            // target在[mid]
            else return mid;
        }

        // 此时 left == right, 如果存在target则必然为这个元素。
        return nums[left] == target? left: -1;
    }
}