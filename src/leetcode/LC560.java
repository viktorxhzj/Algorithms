package leetcode;

import java.util.HashMap;

public class LC560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > map = new HashMap< >();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
