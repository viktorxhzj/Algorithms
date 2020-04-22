import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                TreeNode temp = q.poll();
                if (i == 0) res.add(temp.val);
                if (temp.right != null) q.offer(temp.right);
                if (temp.left != null) q.offer(temp.left);
            }
        }
        return res;
    }
}