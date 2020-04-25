import datastructure.TreeNode;

public class LC111 {
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int count) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res = Math.min(res, count + 1);
            return ;
        }
        dfs(node.left, count + 1);
        dfs(node.right, count + 1);
    }
}