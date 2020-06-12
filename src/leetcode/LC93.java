package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC93 {
    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        recur(s, 0, 0, new StringBuilder());
        return res;
    }
    public void recur(String s, int depth, int i, StringBuilder bd) {
        /* 如果剩余的数字太多了，剪枝 */
        if (s.length() - i > (4 - depth) * 3) return;

        if (depth == 4) {
            if (i < s.length()) return;
            bd.deleteCharAt(bd.length() - 1);
            res.add(bd.toString());
            return;
        }
        if (i >= s.length()) return;

        int len = bd.length();

        for (int j = 1; j <= 3; j++) {
            if (i + j > s.length()) break;
            int num = Integer.parseInt(s.substring(i, j + i));
            if (num > 255) break;
            if(String.valueOf(num).length() != j) break;
            bd.append(num);
            bd.append('.');
            recur(s, depth + 1, i + j, bd);
            bd.setLength(len);
        }
    }
}
