package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC131 {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        recur(s.toCharArray(), 0, new ArrayList<>());
        return ans;
    }

    private void recur(char[] str, int depth, List<String> list) {
        if (depth >= str.length) {
            ans.add(new ArrayList<>(list));
            return;
        }


        for (int k = depth; k < str.length; k++) {
            if (!isPalin(str, depth, k)) continue;
            list.add(new String(str, depth, k - depth + 1));
            recur(str, k + 1, list);
            list.remove(list.size() - 1);
        }

    }




    private boolean isPalin(char[] str, int i, int j) {
        while (i < j) {
            if (str[i] != str[j]) return false;
            i++;
            j--;
        }
        return str[i] == str[j];
    }
}
