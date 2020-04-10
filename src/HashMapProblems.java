import java.util.HashMap;

/**
 * LeetCode 1
 * Two sum
 */
class LC1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            else map.put(nums[i], i);
        }
        return res;
    }
}


/**
 * 剑指50
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 */
class JZ50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            map.put(c, !map.containsKey(c));
        }
        for (char c: chars) {
            if (map.get(c)) return c;
        }
        return ' ';
    }
}