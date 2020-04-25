import datastructure.TreeNode;

public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode parent = new TreeNode(nums[mid]);
        parent.left = dfs(nums, low, mid - 1);
        parent.right = dfs(nums, mid + 1, high);
        return parent;
    }
}