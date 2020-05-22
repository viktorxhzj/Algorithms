package leetcode;

import datastructure.TreeNode;

import java.util.Stack;

public class LC173 {
}

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node;
    int i;
    public BSTIterator(TreeNode root) {
        node = root;
    }

    /** @return the next smallest number */
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int res = node.val;
        node = node.right;
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return !stack.isEmpty();
    }
}