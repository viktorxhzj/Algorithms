import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * 剑指38
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 思路：回溯算法+剪枝
 */
class JZ38 {
    ArrayList<String> list = new ArrayList<>();
    public String[] permutation(String s) {
        if (s.length() == 0) return new String[]{};
        StringBuilder builder = new StringBuilder();
        char[] strs = s.toCharArray();
        boolean[] used = new boolean[strs.length];
        dfs(builder, s.toCharArray(), used, 0, strs.length);
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }

    public void dfs(StringBuilder builder, char[] strs, boolean[] used, int depth, int length) {
        if (depth == length) list.add(builder.toString());
        outer: for (int i = 0; i < strs.length; i++) {
            if (used[i]) continue;
            if (!used[i]) {
                for (int j = 0; j < i; j++) {
                    if (strs[j] == strs[i] && !used[j]) continue outer;
                }
                builder.append(strs[i]);
                used[i] = true;
                dfs(builder, strs, used, depth + 1, length);
                builder.deleteCharAt(builder.length() - 1);
                used[i] = false;
            }
        }
    }
}

