package leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 */
public class LC209 {
    public int minSubArrayLen(int s, int[] arr) {
        int i = 0, j = 0, sum = 0, minLen = arr.length + 1;

        while (j < arr.length) {
            sum += arr[j];
            if (sum >= s) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= arr[i];
                sum -= arr[j];
                i++;
                continue;
            }
            if (sum < s) {
                j++;
            }
        }
        return minLen == arr.length + 1? 0: minLen;
    }
}
