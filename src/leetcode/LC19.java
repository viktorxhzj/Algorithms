package leetcode;

import datastructure.ListNode;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p2 = dummy, p1 = dummy;

        for (int k = 0; k < n; k++) p2 = p2.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;
        return dummy.next;
    }
}
