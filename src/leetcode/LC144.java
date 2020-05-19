package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
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
        
        while (!stack.isEmpty()) {

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

class LC144II {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 用于存放结果
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        // 已遍历到的节点的集合
        HashSet<TreeNode> set = new HashSet<>();
        // 模拟系统栈
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {

            // 1. 如果为空，返回父节点 -> 等同于递归终止基
            if (cur == null) {
                cur = stack.peek();
            }
            // 2. 不为空，且第一次遍历到
            else if (!set.contains(cur)) {
                // 先序遍历：第一次遍历到就输出
                res.add(cur.val);

                // 将节点加入已遍历到的节点的集合
                set.add(cur);

                // 将节点加入栈
                stack.push(cur);

                // 向左节点进发 -> 等同于递归左节点
                cur = cur.left;
            }
            // 3. 不为空，且不是第一次遍历到，隐含着说明左节点已经遍历到
            else {
                // 3.1 有右节点且右节点没有遍历到
                if (cur.right != null && !set.contains(cur.right)) {
                    // 向右节点进发 -> 等同于递归右节点
                    cur = cur.right;
                }
                // 3.2 有右节点但右节点遍历到了
                // 3.3 没有右节点
                // -> 该节点和子节点都访问完了，可以出栈
                else {
                    // 该节点出栈
                    stack.pop();

                    if (!stack.isEmpty()) cur = stack.peek();
                    else cur = null;
                }

            }
        }
        return res;
    }
}