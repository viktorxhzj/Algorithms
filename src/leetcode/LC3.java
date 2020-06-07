package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int maxLen = 1;

        char[] str = s.toCharArray();

        /*
        i - 左边界
        j - 右边界
        */
        int i = 0, j = 1;

        Map<Character, Integer> position = new HashMap<>();
        position.put(str[i], i);

        while (j < str.length) {
            if (position.containsKey(str[j]) && position.get(str[j]) >= i) i = position.get(str[j]) + 1;
            maxLen = Math.max(maxLen, j - i + 1);
            position.put(str[j], j);
            j++;
        }
        return maxLen;
    }
}
