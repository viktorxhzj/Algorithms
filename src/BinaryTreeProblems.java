public class BinaryTreeProblems {
    /**
     * 剑指26
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * 思路：遍历二叉树，判断每一个节点为根节点的情况
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (helper26(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean helper26(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return helper26(A.left, B.left) && helper26(A.right, B.right);
    }


    /**
     * 剑指27
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 思路：左右对换
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        helper27(root);
        return root;
    }
    public void helper27(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        helper27(node.left);
        helper27(node.right);
    }

    /**
     * 剑指28
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 思路：左左=右右，左右=右左
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper28(root.left, root.right);
    }
    boolean helper28(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return helper28(L.left, R.right) && helper28(L.right, R.left);
    }

}
