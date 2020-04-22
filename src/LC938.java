import datastructure.TreeNode;

public class LC938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        // 不在范围内，请去右子树寻找
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        // 不在范围内，请去左子树寻找。
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        // 在范围内，返回值增加该节点值，并向左右子树寻找
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}