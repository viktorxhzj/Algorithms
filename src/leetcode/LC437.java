package leetcode;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC437 {
    int target;
    int res;
    Map<Integer, Integer> map = new HashMap<>();

    {
        map.put(0, 1);
    }

    public int pathSum(TreeNode root, int sum) {
        target = sum;
        recur(root, 0);
        return res;
    }

    public void recur(TreeNode node, int sum) {
        if (node == null) return;
        sum += node.val;

        res += map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        recur(node.left, sum);
        recur(node.right, sum);

        map.put(sum, map.get(sum) - 1);
    }
}
