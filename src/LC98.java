import datastructure.TreeNode;

public class LC98 {
    public boolean isValidBST(TreeNode root) {
        return core(root, null, null);
    }

    public boolean core(TreeNode node, TreeNode max, TreeNode min) {
        // 当前节点为空，肯定符合二叉搜索树
        if (node == null) return true;

        // 当前节点必须小于max值
        if (max != null && max.val <= node.val) return false;

        // 当前节点必须大于min值
        if (min != null && min.val >= node.val) return false;

        // 递归左节点：更新max值， 递归右节点：更新min值
        return core(node.left, node, min) && core(node.right, max, node);
    }
}