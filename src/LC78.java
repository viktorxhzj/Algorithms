import java.util.ArrayList;

public class LC78 {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return list;
    }

    public void backTrack(int[] nums, int depth, ArrayList<Integer> queue) {
        if (depth == nums.length) {
            list.add(new ArrayList<>(queue));
            return ;
        }
        // 添加该节点
        queue.add(nums[depth]);
        backTrack(nums, depth + 1, queue);
        queue.remove(queue.size() - 1);

        // 不添加该节点
        backTrack(nums, depth + 1, queue);
    }
}
