package leetcode;

import datastructure.ListNode;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy, cur = head;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }

        ListNode p1 = cur, p2 = cur.next;

        for (int i = m; i < n; i++) {
            ListNode nxt = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = nxt;
        }

        pre.next.next = p2;
        pre.next = p1;

        return dummy.next;
    }
}
