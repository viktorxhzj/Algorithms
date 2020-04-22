import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();  // 遍历结果
        if (root == null) return res;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {   // 先将所有的左节点的内容压入栈中
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();    // 出栈的时候进行遍历
            res.add(cur.val);
            cur = cur.right;     // 代表开始遍历右子树
        }
        return res;
    }
}