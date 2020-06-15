package leetcode;

import datastructure.ListNode;

public class LC143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        /* 找到中间节点 */
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /* 分隔链表 */
        ListNode p2 = slow.next, p1 = head;
        slow.next = null;

        /* 将第二段链表翻转 */
        p2 = reverse(p2);


        /* 交替穿插 */
        while (p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = tmp;
        }
    }


    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}
