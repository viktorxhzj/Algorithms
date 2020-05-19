package leetcode;

public class LC55 {
    public boolean canJump(int[] nums) {
        // if (nums == null || nums.length == 0) return false;

        int maxL = 0;

        for (int i = 0; i < nums.length; i++) {

            if (maxL >= nums.length - 1) return true;

            if (i > maxL) return false;

            maxL = Math.max(maxL, nums[i] + i);
        }
        return false;
    }
}
