package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC78 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] arr) {
        backTrack(arr, 0, new LinkedList<>());
        return ans;
    }

    private void backTrack(int[] arr, int depth, Deque<Integer> stack) {
        if (depth == arr.length) {
            ans.add(new ArrayList<>(stack));
            return ;
        }
        /* 1 添加该节点 */
        stack.addLast(arr[depth]);
        backTrack(arr, depth + 1, stack);
        stack.removeLast();

        /* 2 不添加该节点 */
        backTrack(arr, depth + 1, stack);
    }
}
