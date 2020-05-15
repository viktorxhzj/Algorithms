package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] cs = str.toCharArray();
            int[] count = new int[26];
            for (char c: cs) {
                count[c - 'a']++;
            }
            StringBuilder bd = new StringBuilder();
            for (int i: count) {
                bd.append(i);
                bd.append(',');
            }
            String p = bd.toString();
            if (!map.containsKey(p)) map.put(p, new ArrayList<>());
            map.get(p).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (String str: map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }
}
