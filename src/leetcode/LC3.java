package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        Arrays.fill(map, -1);

        char[] str = s.toCharArray();

        int maxLen = 0, i = 0;

        for (int j = 0; j < str.length; j++) {
            if (map[str[j]] != -1) {
                i = Math.max(i, map[str[j]] + 1);
            }
            map[str[j]] = j;
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}
