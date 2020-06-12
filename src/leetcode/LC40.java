package leetcode;

import java.util.*;

public class LC40 {
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Deque<Integer> stack = new LinkedList<>();
        Arrays.sort(candidates);
        bt(candidates, 0, target, stack);
        return list;
    }

    private void bt(int[] arr, int depth, int res, Deque<Integer> stack) {
        /* 终止条件 1：达到目标总和 */
        if (res == 0) {
            list.add(new ArrayList<>(stack));
            return;
        }
        /* 终止条件 2：达到数组末端，或者已超过目标总和 */
        if (depth == arr.length || res < 0) return;

        for (int k = depth; k < arr.length; k++) {
            /* 因为已经排序，可以通过和前一个元素的比较避免重复 */
            if (k > depth && arr[k] == arr[k - 1]) continue;

            res -= arr[k];
            stack.addLast(arr[k]);

            bt(arr, k + 1, res, stack);

            /* 状态重置 */
            stack.removeLast();
            res += arr[k];
        }

    }
}
