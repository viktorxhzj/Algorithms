package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || s.length() == 0 || words.length == 0 || s.length() < words.length) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        int wordNum = words.length;
        int strLen = s.length();
        for (int i = 0; i < wordLen; i++) {
            int j = i;
            outer: while (j + wordNum * wordLen - 1 < strLen) {
                Map<String, Integer> reg = new HashMap<>();
                Map<String, Integer> pos = new HashMap<>();
                for (int k = j, time = 0; time < wordNum; k = k + wordLen, time++) {
                    String tmp = s.substring(k, k + wordLen);
                    if (!map.containsKey(tmp)) {
                        j = k + wordLen;
                        continue outer;
                    }
                    pos.put(tmp, pos.getOrDefault(tmp, k));
                    reg.put(tmp, reg.getOrDefault(tmp, 0) + 1);
                    if (reg.get(tmp) > map.get(tmp)) {
                        j = pos.get(tmp) + wordLen;
                        continue outer;
                    }
                }
                res.add(j);
                j = j + wordLen;
            }
        }
        return res;
    }
}
