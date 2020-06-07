package leetcode;

import java.util.Arrays;

public class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int dif = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < dif) {
                    dif = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum == target) return ans;
                else if (sum < target) i++;
                else j--;
            }
        }
        return ans;
    }
}
