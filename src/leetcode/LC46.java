package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return list;
        permutation(nums, 0, new ArrayList<Integer>());
        return list;
    }
    public void permutation(int[] nums, int depth, ArrayList<Integer> queue) {
        if (depth == nums.length) {
            list.add(new ArrayList<>(queue));
            return;
        }
        for (int k = depth; k < nums.length; k++) {
            swap(nums, k, depth);
            queue.add(nums[depth]);
            permutation(nums, depth + 1, queue);
            swap(nums, k, depth);
            queue.remove(queue.size() - 1);
        }
    }

    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}