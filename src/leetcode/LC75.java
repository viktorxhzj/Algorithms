package leetcode;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class LC75 {
    public void sortColors(int[] nums) {
        /*
        循环不变量
        i       0的右边界
        j       2的左边界
        ptr     遍历的指针
         */
        int i = 0, j = nums.length - 1, ptr = 0;
        while (ptr <= j) {
            if (nums[ptr] == 0) {
                swap(nums, i, ptr);
                i++;
                ptr++;
            } else if (nums[ptr] == 1) {
                ptr++;
            } else {
                swap(nums, ptr, j);
                j--;
            }
        }
    }

    public void swap(int[] nums, int k, int m) {
        int temp = nums[k];
        nums[k] = nums[m];
        nums[m] = temp;
    }
}
