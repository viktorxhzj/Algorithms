package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;

        /* word-# */
        HashMap<String, Integer> map = new HashMap<>();
        int wordLen = words[0].length();
        int wordNum = words.length;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            /*
            left    左边界
            right   右边界
             */
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tempMap = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String w = s.substring(right, right + wordLen);
                right += wordLen;
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tempMap.clear();
                } else {
                    tempMap.put(w, tempMap.getOrDefault(w, 0) + 1);
                    count++;
                    while (tempMap.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + wordLen);
                        count--;
                        tempMap.put(t_w, tempMap.getOrDefault(t_w, 0) - 1);
                        left += wordLen;
                    }
                    if (count == wordNum) res.add(left);
                }
            }
        }
        return res;
    }
}
