package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC47 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return list;
        permutation(nums, 0, new ArrayList<Integer>());
        return list;
    }
    public void permutation(int[] nums, int depth, ArrayList<Integer> queue) {
        if (depth == nums.length) {
            list.add(new ArrayList<>(queue));
            return;
        }

        // 交换会破坏顺序，所以排序后用nums[k] == nums[k - 1]判断同层重复是不充分的
        HashSet<Integer> set = new HashSet<>();
        for (int k = depth; k < nums.length; k++) {
            if (set.contains(nums[k])) continue;
            set.add(nums[k]);
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

    public static void main(String[] args) {
        LC47 algo = new LC47();
        int[] arr = new int[]{2, 2, 1, 1};
        List<List<Integer>> res = algo.permuteUnique(arr);
    }
}