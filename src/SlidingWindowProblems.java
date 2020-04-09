import java.util.HashMap;

/**
 * 剑指48
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 思路：滑动窗口
 */
class JZ48II {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        char[] strs = s.toCharArray();
        int i = 0, j = 0, res = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(strs[i], 0);
        while (j < strs.length - 1) {
            j++;
            if (map.containsKey(strs[j])) i = Math.max(map.get(strs[j]) + 1, i);
            map.put(strs[j], j);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        JZ48II test = new JZ48II();
        test.lengthOfLongestSubstring("abba");
    }
}