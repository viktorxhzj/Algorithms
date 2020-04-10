/**
 * 剑指21
 * 调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 思路：首尾双指针
 */
class JZ21 {
    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1, temp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[j] & 1) == 0) j--;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}

/**
 * 剑指57
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 *
 * 思路：首位双指针
 */
class JZ57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) i++;
            else if (nums[i] + nums[j] > target) j--;
            else return new int[]{nums[i], nums[j]};

        }
        return new int[2];
    }
}