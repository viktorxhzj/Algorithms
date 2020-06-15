package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {
    private Set<String> wordSet;
    private Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];

        return recur(s, 0);
    }
    public boolean recur(String s, int i) {
        if (i == s.length()) return true;
        if (memo[i] != null) return memo[i];

        for (int j = i + 1; j <= s.length(); j++) {
            String possible = s.substring(i, j);
            if (!wordSet.contains(possible)) continue;
            if (recur(s, j)) {
                memo[i] = true;
                return true;
            }
        }
        memo[i] = false;
        return false;
    }
}
