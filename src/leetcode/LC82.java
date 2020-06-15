package leetcode;

import datastructure.ListNode;

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-99999);
        dummy.next = head;
        ListNode p1 = dummy, p2 = head, p3 = head.next;
        while (p3 != null) {
            if (p2.val != p3.val) {
                p1 = p1.next;
                p2 = p2.next;
                p3 = p3.next;
                continue;
            }
            while (p3 != null && p3.val == p2.val) p3 = p3.next;
            p1.next = p3;
            p2 = p3;
            if (p3 != null) p3 = p3.next;
        }
        return dummy.next;

    }
}
