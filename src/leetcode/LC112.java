package leetcode;

import datastructure.TreeNode;

public class LC112 {
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(sum, root);
        return res;
    }
    public void dfs(int rest, TreeNode node) {
        // 如果当前为空节点
        if (node == null) return ;
        if (res == true) return ;

        rest -= node.val;

        // 如果当前为叶节点且总和等于目标
        if (node.left == null && node.right == null && rest == 0) res = true;
        dfs(rest, node.left);
        dfs(rest, node.right);
    }
}