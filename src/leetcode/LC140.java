package leetcode;

import java.util.*;

public class LC140 {
    private Set<String> set;

    private List[] memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new List[s.length()];

        recur(s, 0);

        return memo[0];
    }


    private List<String> recur(String s, int i) {
        ArrayList<String> local = new ArrayList<>();
        if (i == s.length()) {
            local.add("");
            return local;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        for (int j = i + 1; j <= s.length(); j++) {
            String possible = s.substring(i, j);
            if (!set.contains(possible)) continue;

            List<String> next = recur(s, j);
            for (String str : next) {
                local.add(possible + (str.equals("") ? "" : " ") + str);
            }
        }
        memo[i] = local;
        return local;
    }
}
