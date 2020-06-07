package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int[] need = new int[26];

        for (char c: p.toCharArray()) {
            need[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (need[i] == 0) need[i] = -1;
        }

        char[] str = s.toCharArray();

        int i = 0, j = 0, count = 0;
        while (j < str.length) {
            if (need[str[j] - 'a'] == -1) {
                while (i < j) {
                    need[str[i] - 'a']++;
                    count--;
                    i++;
                }
                i++;
                j++;
                count = 0;
                continue;
            }
            while (need[str[j] - 'a'] == 0) {
                need[str[i] - 'a']++;
                count--;
                i++;
            }
            need[str[j] - 'a']--;
            count++;
            if (count == p.length()) ans.add(i);
            j++;
        }
        return ans;
    }
}
