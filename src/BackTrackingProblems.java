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
            StringBuilder bd = new StringBuilder();
        }
    }

    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}

/**
 * 电话号码的数字组合
 *
 * 回溯
 */
class LC17 {
    HashMap<Character, char[]> map = new HashMap<>();
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return list;
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        char[] nums = digits.toCharArray();
        bt(nums, 0, new StringBuilder());
        return list;

    }

    public void bt(char[] chars, int depth, StringBuilder bd) {
        if (depth == chars.length) {
            list.add(bd.toString());
            return ;
        }
        for (int k = 0; k < map.get(chars[depth]).length; k++) {
            bd.append(map.get(chars[depth])[k]);
            bt(chars, depth + 1, bd);
            bd.deleteCharAt(bd.length() - 1);
        }
    }
}

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集
 */
class LC78 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return list;
    }

    public void backTrack(int[] nums, int depth, ArrayList<Integer> queue) {
        if (depth == nums.length) {
            ArrayList<Integer> local = new ArrayList<>(queue);
            list.add(local);
            return ;
        }
        queue.add(nums[depth]);
        backTrack(nums, depth + 1, queue);
        queue.remove(queue.size() - 1);
        backTrack(nums, depth + 1, queue);
    }
}

class LC90 {
    List<List<Integer>> list = new ArrayList<>();
    HashMap<Integer, Boolean> map = new HashMap<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return list;
    }

    public void backTrack(int[] nums, int depth, ArrayList<Integer> queue) {
        if (depth == nums.length) {
            ArrayList<Integer> local = new ArrayList<>(queue);
            list.add(local);
            return ;
        }
        if (!map.containsKey(nums[depth]) || !map.get(nums[depth])) {
            map.put(nums[depth], true);
            queue.add(nums[depth]);
            backTrack(nums, depth + 1, queue);
            queue.remove(queue.size() - 1);
            map.put(nums[depth], false);
            backTrack(nums, depth + 1, queue);
        }
        else {
            queue.add(nums[depth]);
            backTrack(nums, depth + 1, queue);
            queue.remove(queue.size() - 1);
        }

    }
}