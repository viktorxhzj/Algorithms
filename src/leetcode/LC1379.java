package leetcode;

import datastructure.TreeNode;

public class LC1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        // 递归左子树
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null) return res;
        // 递归右子树
        res = getTargetCopy(original.right, cloned.right, target);
        if (res != null) return res;
        return null;
    }
}