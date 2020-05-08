package leetcode;

import datastructure.TreeNode;

import java.util.Stack;

public class LC572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.val == t.val && validation(temp, t)) return true;
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return false;
    }

    public boolean validation(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        return validation(n1.left, n2.left) && validation(n1.right, n2.right);
    }
}