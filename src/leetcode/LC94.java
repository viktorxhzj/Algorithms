package leetcode;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LC94 {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // 用来存放结果
        ArrayList<Integer> res = new ArrayList<>();

        // 模拟系统的栈
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return res;

        TreeNode node = root;

        while (true) {
            // 如果有左节点就一直进栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 进栈完就要出栈，如果空了就退出
            if (stack.isEmpty()) break;

            // 栈顶节点一定是当前最左节点
            node = stack.pop();
            res.add(node.val);

            // 转向右节点
            node = node.right;
        }
        return res;
    }
}

class LC94II {
    public List<Integer> inorderTraversal(TreeNode root) {
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
                    res.add(cur.val);

                    // 向右节点进发 -> 等同于递归右节点
                    cur = cur.right;
                }
                // 3.2 有右节点但右节点遍历到了
                else if (cur.right != null) {
                    // 该节点出栈
                    stack.pop();

                    if (!stack.isEmpty()) cur = stack.peek();
                    else cur = null;
                }
                // 3.3 没有右节点
                else {
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