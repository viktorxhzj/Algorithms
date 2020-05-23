package leetcode;

import datastructure.ListNode;

public class LC86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode p1 = new ListNode(-1), p2 = new ListNode(-1);
        ListNode p1Dummy = p1, p2Dummy = p2, cur = head;


        while (cur != null) {
            ListNode nxt = cur.next;
            if (cur.val < x) {
                p1.next = cur;
                p1 = p1.next;
            }
            else {
                p2.next = cur;
                p2 = p2.next;
            }
            cur = nxt;
        }
        p1.next = p2Dummy.next;
        p2.next = null;
        return p1Dummy.next;
    }
}
