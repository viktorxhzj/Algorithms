import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        boolean odd = true;
        q.offer(root);
        while (!q.isEmpty()) {
            int k = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            if (odd) {
                while (--k >= 0) {
                    TreeNode node = q.poll();
                    temp.add(node.val);
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
            }
            else {
                recur(q, temp, k);
            }
            res.add(temp);
            odd = !odd;
        }
        return res;
    }

    public void recur(Queue<TreeNode> q, ArrayList<Integer> temp, int size) {
        if (size == 0) return ;
        TreeNode node = q.poll();
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
        recur(q, temp, size - 1);
        temp.add(node.val);
    }
}