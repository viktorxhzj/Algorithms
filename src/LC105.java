import datastructure.TreeNode;

public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preOrder, int[] inOrder, int pLow, int pHigh, int iLow, int iHigh) {
        if (pLow > pHigh) return null;
        TreeNode root = new TreeNode(preOrder[pLow]);
        int rootPos = iLow;
        // 找到根节点在中序遍历中的索引
        while (inOrder[rootPos] != preOrder[pLow]) rootPos++;
        // 递归左子树
        root.left = helper(preOrder, inOrder, pLow + 1, pLow + rootPos - iLow, iLow, rootPos - 1);
        // 递归右子树
        root.right = helper(preOrder, inOrder, pLow + rootPos - iLow + 1, pHigh, rootPos + 1, iHigh);
        return root;
    }
}