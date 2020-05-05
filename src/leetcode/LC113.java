package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import datastructure.TreeNode;

public class LC113 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> arr = new LinkedList<>();
        preOrder(arr, sum, root);
        return res;
    }

    public void preOrder(LinkedList<Integer> list, int rest, TreeNode node) {
        // 如果当前为空节点
        if (node == null) return ;

        rest -= node.val;
        list.offerLast(node.val);

        // 如果当前为叶节点且总和等于目标
        if (node.left == null && node.right == null && rest == 0) {
            res.add(new LinkedList<>(list));
            list.pollLast();
            return ;
        }
        preOrder(list, rest, node.left);
        preOrder(list, rest, node.right);
        list.pollLast();
    }
}