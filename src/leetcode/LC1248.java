package leetcode;

public class LC1248 {
    public int numberOfSubarrays(int[] nums, int k) {

        int[] map = new int[nums.length + 1];
        map[0] = 1;

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += (num & 1);
            if (sum - k >= 0) count += map[sum - k];
            map[sum] += 1;
        }

        return count;

    }
}
