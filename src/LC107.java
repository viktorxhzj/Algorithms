import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.TreeNode;

public class LC107 {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int k = q.size();
                ArrayList<Integer> temp = new ArrayList<>();
                while (--k >= 0) {
                    TreeNode node = q.poll();
                    temp.add(node.val);
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
                res.offerFirst(temp);
            }
            return res;
        }
    }
}