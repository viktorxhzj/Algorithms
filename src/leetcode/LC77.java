package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;
        dfs(0, arr, k, new ArrayList<Integer>());
        return res;
    }


    public void dfs(int depth, int[] arr, int left, ArrayList<Integer> q) {
        if (arr.length - depth  < left) return;
        if (left == 0) {
            res.add(new ArrayList<>(q));
            return;
        }
        q.add(arr[depth]);
        dfs(depth + 1, arr, left - 1, q);
        q.remove(q.size() - 1);

        dfs(depth + 1, arr, left, q);
    }

    public static void main(String[] args) {
        LC77 algo = new LC77();
        List<List<Integer>> res = algo.combine(4, 2);
    }
}
