package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC216 {
    private List<List<Integer>> res = new ArrayList<>();
    private final int[] NUMS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, n, k, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int depth, int residual, int countLeft, ArrayList<Integer> q) {
        // 1. 如果剩余的元素比所需剩余元素少，则可提前剪枝
        if (NUMS.length - depth < countLeft) return;

        // 2. 如果总和超过n，或者总个数超过k，则可提前剪枝
        if (residual < 0 || countLeft < 0) return;

        // 3. 当且仅当总和为n，总个数为k时，返回
        if (residual == 0 && countLeft == 0) {
            res.add(new ArrayList<>(q));
            return;
        }

        // 4. 如果已经达到数组终点（且不符合返回的条件），则终止
        if (depth == NUMS.length) return;


        // 情况1：选择当前元素，更新总和和总个数
        q.add(NUMS[depth]);
        residual -= NUMS[depth];
        countLeft--;
        dfs(depth + 1, residual, countLeft, q);
        countLeft++;
        residual += NUMS[depth];
        q.remove(q.size() - 1);

        // 选择2：不选择当前元素，前往下个元素
        dfs(depth + 1, residual, countLeft, q);
    }

    public static void main(String[] args) {
        LC216 algo = new LC216();
        List<List<Integer>> res = algo.combinationSum3(3, 7);
    }
}
