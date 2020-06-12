package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC77 {
    /* 答案集合 */
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;

        dfs(0, arr, k, new LinkedList<>());
        return ans;
    }


    private void dfs(int depth, int[] arr, int left, Deque<Integer> stack) {
        /* 如果剩余的元素不够选了，剪枝 */
        if (arr.length - depth  < left) return;

        if (left == 0) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        /* 1 选择添加当前元素，向下个元素递归 */
        stack.addLast(arr[depth]);
        dfs(depth + 1, arr, left - 1, stack);
        stack.removeLast();

        /* 2 不选择当前元素 */
        dfs(depth + 1, arr, left, stack);
    }

}
