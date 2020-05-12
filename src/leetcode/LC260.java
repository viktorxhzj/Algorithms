package leetcode;

public class LC260 {
    public int[] singleNumber(int[] nums) {

        int xorRes = 0;
        for (int num: nums) xorRes ^= num;

        int shift = 0;
        while (((xorRes >> shift) & 1) == 0) shift++;

        int[] res = new int[2];
        for (int num: nums) {
            if (((num >> shift) & 1) == 1) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
