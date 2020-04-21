import datastructure.TreeNode;

import java.util.ArrayList;

/**
 * 剑指33
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 思路：分而治之（递归)
 */
class JZ33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) return true;
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] arr, int low, int high) {
        if (low >= high) return true;
        int i = low;
        while (arr[i] < arr[high]) i++;
        int j = i;
        while (arr[i] > arr[high]) i++;
        return i == high && helper(arr, low, j - 1) && helper(arr, j, high - 1);
    }
}

/**
 * 剑指36
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 思路：In-Order即为排序
 */

class JZ36 {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        if (list.size() == 1) {
            list.get(0).right = list.get(0);
            list.get(0).left = list.get(0);
            return list.get(0);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                list.get(i).left = list.get(list.size() - 1);
                list.get(i).right = list.get(i + 1);
            }
            else if (i == list.size() - 1) {
                list.get(i).left = list.get(i - 1);
                list.get(i).right = list.get(0);
            }
            else {
                list.get(i).left = list.get(i - 1);
                list.get(i).right = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    public void inOrder(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }
}

/**
 * 剑指54
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 思路：In-Order
 */
class JZ54 {
    int count = 0;
    int res;
    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    public void inOrder(TreeNode node, int k) {
        if (node == null) return ;
        inOrder(node.right, k);
        count++;
        if (count == k) {
            res = node.val;
            return ;
        }
        inOrder(node.left, k);
    }
}

/**
 * 剑指68-I
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 思路：DFS
 */
class JZ68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}

class LC938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        // 不在范围内，请去右子树寻找
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        // 不在范围内，请去左子树寻找。
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        // 在范围内，返回值增加该节点值，并向左右子树寻找
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}