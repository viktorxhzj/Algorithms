import datastructure.TreeNode;

public class LC104 {
    int res = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int count) {
        if (node == null) return ;
        if (node.right == null && node.left == null) {
            res = Math.max(res, count + 1);
            return ;
        }
        dfs(node.left, count + 1);
        dfs(node.right, count + 1);
    }
}