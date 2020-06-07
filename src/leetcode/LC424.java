package leetcode;

public class LC424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        char[] str = s.toCharArray();
        int[] map = new int[26];

        int maxLen = k;
        int i = 0, j = 0, maxCount = 0;
        while (j < str.length) {
            map[str[j] - 'A']++;
            maxCount = Math.max(map[str[j] - 'A'], maxCount);
            if (maxCount + k >= j - i + 1) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
                continue;
            }
            if (maxCount + k < j - i + 1) {
                map[str[i] - 'A']--;
                i++;

                map[str[j] - 'A']--;
            }
        }

        return maxLen;

    }
}
