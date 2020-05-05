package leetcode;

import java.util.ArrayList;

public class LC47 {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        ArrayList<Integer> queue = new ArrayList<>();
        permutation(nums, 0, queue, list);
        return list;
    }
    public void permutation(int[] nums, int depth, ArrayList<Integer> queue, ArrayList<ArrayList<Integer>> list) {
        if (depth == nums.length) list.add(new ArrayList<>(queue));
        outer: for (int k = depth; k < nums.length; k++) {
            for (int j = depth; j < k; j++) {
                // 如果和当前层之前节点值相等，跳过
                if (nums[k] == nums[j]) continue outer;
            }
            swap(nums, k, depth);
            queue.add(nums[depth]);
            permutation(nums, depth + 1, queue, list);
            swap(nums, k, depth);
            queue.remove(queue.size() - 1);
            StringBuilder bd = new StringBuilder();
        }
    }

    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}