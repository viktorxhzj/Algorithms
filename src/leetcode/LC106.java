package leetcode;

import datastructure.TreeNode;

public class LC106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inOrder, int[] postOrder, int iLow, int iHigh, int pLow, int pHigh) {
        if (iLow > iHigh) return null;
        TreeNode root = new TreeNode(postOrder[pHigh]);
        int rootPos = iLow;
        // 找到根节点在中序遍历中的索引
        while (inOrder[rootPos] != postOrder[pHigh]) rootPos++;
        // 递归左子树
        root.left = helper(inOrder, postOrder, iLow, rootPos - 1, pLow, pLow - iLow + rootPos -1);
        // 递归右子树
        root.right = helper(inOrder, postOrder, rootPos + 1, iHigh, pLow - iLow + rootPos, pHigh - 1);
        return root;
    }
}