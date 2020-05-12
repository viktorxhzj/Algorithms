package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> queue = new ArrayList<>();
        Arrays.sort(candidates);
        bt(candidates, 0, target, queue);
        return list;
    }

    public void bt(int[] arr, int depth, int res, ArrayList<Integer> queue) {
        if (res == 0) {
            list.add(new ArrayList<>(queue));
            return;
        }
        if (depth == arr.length || res < 0) return;

        for (int k = depth; k < arr.length; k++) {
            if (k > depth && arr[k] == arr[k - 1]) continue;
            res -= arr[k];
            queue.add(arr[k]);
            bt(arr, k + 1, res, queue);
            queue.remove(queue.size() - 1);
            res += arr[k];
        }

    }
}
