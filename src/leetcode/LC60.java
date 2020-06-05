package leetcode;

import java.util.ArrayList;

public class LC60 {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder bd = new StringBuilder();
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            list.add(i);
            fact[i] = fact[i - 1] * i;
        }
        int i;
        for (i = 0, k--; i < n; i++) {
            int index = k / fact[n - i - 1];
            bd.append(list.remove(index));
            k %= fact[n - i - 1];
        }
        return bd.toString();
    }
}
