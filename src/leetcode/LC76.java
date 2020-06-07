package leetcode;

public class LC76 {
    public String minWindow(String s, String t) {
        char[] tChar = t.toCharArray();
        char[] str = s.toCharArray();

        int[] need = new int[128];

        int minLen = str.length + 1;
        String result = "";

        for (char c: tChar) {
            need[c]++;
        }

        int i = 0, j = 0, count = 0;
        while (j < str.length) {
            if (need[str[j]] > 0) count++;
            need[str[j]]--;
            //只要达到count就记录长度，并收缩
            if (count == tChar.length) {
                if (j - i + 1 < minLen) {
                    result = s.substring(i, j + 1);
                    minLen = j - i + 1;
                }

                need[str[j]]++;
                if (need[str[j]] > 0) count--;

                need[str[i]]++;
                if (need[str[i]] > 0) count--;

                i++;
                continue;
            }
            //小于count，扩大窗口
            if (count < tChar.length) {
                j++;
            }
            //不可能大于count
        }

        return result;

    }
}
