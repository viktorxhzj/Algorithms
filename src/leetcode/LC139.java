package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return recur(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean recur(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && recur(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
