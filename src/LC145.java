import datastructure.TreeNode;

import java.util.ArrayList;
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