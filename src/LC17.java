import java.util.ArrayList;
import java.util.HashMap;

public class LC17 {
    HashMap<Character, char[]> map = new HashMap<>();
    ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> letterCombinations(String digits) {
        if (digits.length() == 0) return list;
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        char[] nums = digits.toCharArray();
        backTrack(nums, 0, new StringBuilder());
        return list;

    }

    public void backTrack(char[] chars, int depth, StringBuilder bd) {
        // 达到数字串长度的时候，返回
        if (depth == chars.length) {
            list.add(bd.toString());
            return ;
        }
        // 对于每一个数字，遍历所有可能的字符
        for (int k = 0; k < map.get(chars[depth]).length; k++) {
            bd.append(map.get(chars[depth])[k]);
            backTrack(chars, depth + 1, bd);
            bd.deleteCharAt(bd.length() - 1);
        }
    }
}
