package leetcode;

public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int[] res = new int[2];

        // 寻找左边界
        // [l, r)
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;

            // [l...t...r)
            // [l...m...r)
            // [l...r)
            if (nums[m] == target) {
                r = m;
            }

            // [l......t..r)
            // [l....m....r)
            //       [l...r)
            if (nums[m] < target) {
                l = m + 1;
            }

            // [l..t......r)
            // [l....m....r)
            // [l....r)
            if (nums[m] > target) {
                r = m;
            }
        }
        if (l == nums.length) res[0] = -1;
        else res[0] = nums[l] == target? l: -1;

        // 寻找右边界
        // [l, r)
        l = 0;
        r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;

            // [l...t...r)
            // [l...m...r)
            //      [l...r)
            if (nums[m] == target) {
                l = m + 1;
            }

            // [l......t..r)
            // [l....m....r)
            //       [l...r)
            if (nums[m] < target) {
                l = m + 1;
            }

            // [l..t......r)
            // [l....m....r)
            // [l....r)
            if (nums[m] > target) {
                r = m;
            }
        }
        if (l == 0) res[1] = -1;
        else res[1] = nums[l - 1] == target ? (l - 1): -1;

        return res;
    }
}
