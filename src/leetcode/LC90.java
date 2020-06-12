package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC90 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        recur(arr, 0, new LinkedList<>());
        return ans;
    }

    private void recur(int[] arr, int depth, Deque<Integer> stack) {
        if (depth == arr.length) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        stack.addLast(arr[depth]);

        recur(arr, depth + 1, stack);

        stack.removeLast();

        /* 如果不添加当前元素，下个元素必须不相等 */
        int tmp = arr[depth];
        while (depth < arr.length && arr[depth] == tmp) depth++;
        recur(arr, depth, stack);

    }
}
