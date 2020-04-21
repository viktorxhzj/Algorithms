import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

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

/**
 * 剑指57-II
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）
 *
 * 思路：前后双指针
 */
class JZ57II {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int []> list = new ArrayList<>();
        int i = 1, j = 1, sum = 1;
        while (j <= target / 2 + 1) {
            if (sum < target) {
                j++;
                sum += j;
            }
            else if (sum == target) {
                int[] local = new int[j - i + 1];
                for (int k = i; k <= j; k++) local[k - i] = k;
                list.add(local);
                sum -= i;
                i++;
            }
            else {
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[][]{});
    }
}

