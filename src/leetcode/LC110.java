package leetcode;

import datastructure.TreeNode;

public class LC110 {
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return res;
    }

    public int height(TreeNode node) {
        if (node == null) return -1;
        if (res == false) return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        if (Math.abs(leftH - rightH) > 1) res = false;
        return Math.max(leftH, rightH) + 1;
    }
}