package leetcode;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LC145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 用来存放结果
        List<Integer> res = new ArrayList<>();
        // 模拟系统的栈
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        // 用来记录当前节点
        TreeNode node = root;
        // 用来记录上一个弹出节点
        TreeNode pre = null;

        while (true) {
            // 如果有左节点就一直压入栈中
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 没有左节点压了，开始看向栈顶节点，判断栈是否为空
            if (stack.isEmpty()) break;
            node = stack.peek();
            // 如果栈顶节点没有右节点，则是叶节点，可以弹出；
            // 如果栈顶有右节点，但是右节点是上一个弹出的节点，也可以弹出。
            if (node.right == null || pre == node.right) {
                // 弹出节点，打印值
                node = stack.pop();
                res.add(node.val);
                // 更新上个弹出的节点
                pre = node;
                // 更新当前节点为null，防止再次压入栈中
                node = null;
            }
            // 如果有右节点且右节点没有被遍历过，向右节点前进
            else node = node.right;
        }
        return res;
    }
}

class LC145II {
    public List<Integer> postorderTraversal(TreeNode root) {
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
                    // 后序遍历：出栈前输出
                    res.add(cur.val);

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