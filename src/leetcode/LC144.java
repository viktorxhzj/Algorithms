package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructure.TreeNode;

public class LC144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 用来存放结果
        List<Integer> res = new ArrayList<>();

        // 模拟系统的栈
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return res;
        stack.push(root);
        
        while(!stack.isEmpty()) {

            // 打印当前节点
            TreeNode temp = stack.pop();
            res.add(temp.val);

            // 先压右节点
            if (temp.right != null) stack.push(temp.right);

            // 再压左节点
            if (temp.left != null) stack.push(temp.left);

        }
        return res;
    }
}