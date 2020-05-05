package leetcode;

import datastructure.TreeNode;

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || help(root.left, root.right);
    }

    public boolean help(TreeNode q, TreeNode p) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;
        return q.val == p.val && help(q.left, p.right) && help(q.right, p.left);
    }
}