package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC89 {
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<Integer> grayCode(int n) {
        recur(0, n);
        return list;
    }
    public void recur(int num, int n) {
        if (set.contains(num)) return;
        list.add(num);
        set.add(num);
        for (int i = 0; i < n; i++) {
            int k = num ^ (1 << i);
            if (k > 0) recur(k, n);
        }
    }

    public static void main(String[] args) {
        LC89 algo = new LC89();
        List<Integer> res = algo.grayCode(3);
        System.out.println("D");
    }
}
