package leetcode;

import java.util.Arrays;

/**
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 */
public class LC525 {
    public int findMaxLength(int[] nums) {
        int len = 0;
        int sum = nums.length;

        /* 用数组当哈希表 */
        int[] map = new int[nums.length * 2 + 1];

        Arrays.fill(map, -2);

        map[nums.length] = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) sum -= 1;
            else sum += 1;

            /* 不存在当前键值，则该键值第一次出现，记录下标 */
            if (map[sum] == -2) map[sum] = i;

            /* 存在当前键值，第一次出现的下标与当前下标的差即为子数组长度 */
            else len = Math.max(len, i - map[sum]);
        }
        return len;
    }
}
