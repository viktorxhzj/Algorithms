import java.util.ArrayList;
import java.util.HashMap;

public class LC90 {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    // 该元素是否有遍历到，遍历到是否有添加进子集
    HashMap<Integer, Boolean> map = new HashMap<>();

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return list;
    }

    // 生成子集的方法是对于每一个元素，选择添加或者不添加
    public void backTrack(int[] nums, int depth, ArrayList<Integer> queue) {
        // 当达到数组的尽头，添加当前生成的子集
        if (depth == nums.length) {
            list.add(new ArrayList<>(queue));
            return ;
        }

        // 如果当前子集没有遍历到该元素，或者遍历到该元素但选择不添加
        if (!map.containsKey(nums[depth]) || !map.get(nums[depth])) {

            // 1. 没有遍历到该元素，可以将该元素加入子集
            map.put(nums[depth], true);
            queue.add(nums[depth]);
            backTrack(nums, depth + 1, queue);
            queue.remove(queue.size() - 1);

            // 2. 没有遍历到该元素，更新该元素进map，但是不将该元素加入子集
            // 3. 遍历到了该元素，但之前选择不添加，这次依旧不添加
            map.put(nums[depth], false);
            backTrack(nums, depth + 1, queue);
        }
        // 当前子集遍历到了该元素且之前选择了添加，这次就必须也要添加，不然就会有重复
        else {
            queue.add(nums[depth]);
            backTrack(nums, depth + 1, queue);
            queue.remove(queue.size() - 1);
        }

    }
}
