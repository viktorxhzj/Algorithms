import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 用来存放结果
        List<Integer> res = new ArrayList<>();

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

    public static void main(String[] args) {
        LC94 test = new LC94();
        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(2);
        a.right.left = new TreeNode(3);
        test.inorderTraversal(a);
    }
}