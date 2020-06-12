package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        if (S == null || S.length() == 0) return ans;

        char[] str = S.toCharArray();

        int map[] = new int[26];
        boolean[] firstMet = new boolean[26];
        for (char c: str) map[c - 'a']++;

        int i = 0, j = 0, count = 0;
        while (j < str.length) {
            if (!firstMet[str[j] - 'a']) {
                count += map[str[j] - 'a'];
                firstMet[str[j] - 'a'] = true;
            }
            map[str[j] - 'a']--;
            count--;
            if (count == 0) {
                ans.add(j - i + 1);
                j++;
                i = j;
                continue;
            }
            j++;
        }
        return ans;

    }
}
