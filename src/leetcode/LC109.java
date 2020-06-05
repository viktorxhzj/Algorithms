package leetcode;

import datastructure.ListNode;
import datastructure.TreeNode;
// [-10, -3, 0, 5, 9]
public class LC109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode low = head, fast = head, pre = null;

        while (fast != null && fast.next != null) {
            pre = low;
            low = low.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode parent = new TreeNode(low.val);
        parent.left = sortedListToBST(head);
        parent.right = sortedListToBST(low.next);
        return parent;
    }

    public static void main(String[] args) {
        LC109 algo = new LC109();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        algo.sortedListToBST(head);
    }
}
