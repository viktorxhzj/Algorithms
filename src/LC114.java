import java.util.LinkedList;

import datastructure.TreeNode;

public class LC114 {
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return ;
        stack.offerLast(root);
        TreeNode head = new TreeNode(-1);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pollLast();
            head.right = top;
            if (top.right != null) stack.offerLast(top.right);
            if (top.left != null) stack.offerLast(top.left);
            head = top;
            head.left = null;
        }
    }
}