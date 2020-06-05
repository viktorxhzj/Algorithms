package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a: A) {
            for (int b: B) {
                int num = a + b;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int count = 0;

        for (int c: C) {
            for (int d: D) {
                int num = -c - d;
                count += map.getOrDefault(num, 0);
            }
        }
        return count;

    }
}
