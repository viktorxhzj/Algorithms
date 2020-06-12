package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC39 {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        bt(candidates, 0, target, new ArrayList<Integer>());
        return list;
    }


    private void bt(int[] arr, int depth, int res, ArrayList<Integer> queue) {
        // 终止条件1：找到组合
        if (res == 0) {
            list.add(new ArrayList<Integer>(queue));
            return;
        }
        // 终止条件2：非法条件
        if (depth == arr.length || res < 0) return;

        /* 1 继续选取当前元素 */
        queue.add(arr[depth]);
        bt(arr, depth, res - arr[depth], queue);
        /* 1 状态重置 */
        queue.remove(queue.size() - 1);

        /* 2 不再选取当前元素，前往下个元素 */
        bt(arr, depth + 1, res, queue);
    }
}
