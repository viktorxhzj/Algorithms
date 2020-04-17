import java.util.*;

/**
 * 不带重复输入的全排列
 *
 * 思路：回溯（用交换实现）
 */
class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        ArrayList<Integer> queue = new ArrayList<>();
        permutation(nums, 0, queue, list);
        return list;
    }
    public void permutation(int[] nums, int depth, ArrayList<Integer> queue, List<List<Integer>> list) {
        if (depth == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>(queue);
            list.add(temp);
        }
        for (int k = depth; k < nums.length; k++) {
            swap(nums, k, depth);
            queue.add(nums[depth]);
            permutation(nums, depth + 1, queue, list);
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

/**
 * 带重复输入的全排列
 *
 * 思路：回溯+剪枝
 */
class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        ArrayList<Integer> queue = new ArrayList<>();
        permutation(nums, 0, queue, list);
        return list;
    }
    public void permutation(int[] nums, int depth, ArrayList<Integer> queue, List<List<Integer>> list) {
        if (depth == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>(queue);
            list.add(temp);
        }
        outer: for (int k = depth; k < nums.length; k++) {
            for (int j = depth; j < k; j++) {
                if (nums[k] == nums[j] && k != j) continue outer;
            }
            swap(nums, k, depth);
            queue.add(nums[depth]);
            permutation(nums, depth + 1, queue, list);
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
