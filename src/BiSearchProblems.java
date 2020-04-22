





/**
 * 剑指53
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路：BiSearch
 */
class JZ53 {
    public int search(int[] nums, int target) {
        int index = biSearchM(nums, 0, nums.length - 1, target);
        if (index == -1) return 0;
        int count = 1, i = index - 1;
        while (i >= 0 && nums[i] == target) {
            count++;
            i--;
        }
        i = index + 1;
        while (i < nums.length && nums[i] == target) {
            count++;
            i++;
        }
        return count;

    }

    public int biSearchM(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (target == arr[mid]) return mid;
        if (target < arr[mid]) return biSearchM(arr, low, mid - 1, target);
        else return biSearchM(arr, mid + 1, high, target);
    }
}

/**
 * 剑指53-II
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 思路：BiSearch
 */
class JZ53II {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public int biSearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int i = 0, j = nums.length - 1;
        if (target < nums[0] || target > nums[nums.length - 1]) return -1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (target == nums[m]) return m;
            if (nums[m] > target) j = m - 1;
            else i = m + 1;
        }
        return -1;
    }
}

