package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC46 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return ans;
        permutation(nums, 0, new LinkedList<Integer>());
        return ans;
}
    private void permutation(int[] nums, int depth, Deque<Integer> stack) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int k = depth; k < nums.length; k++) {
            swap(nums, k, depth);
            stack.addLast(nums[depth]);
            permutation(nums, depth + 1, stack);
            swap(nums, k, depth);
            stack.removeLast();
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}