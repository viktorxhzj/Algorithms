package leetcode;

import datastructure.ListNode;

public class LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode p3 = null;
        p2 = p1.next;
        p1.next = null;

        while (p2 != null) {
            ListNode nxt = p2.next;
            p2.next = p3;
            p3 = p2;
            p2 = nxt;
        }

        while (p3 != null && head != null) {
            if (head.val != p3.val) return false;
            head = head.next;
            p3 = p3.next;
        }
        return true;
    }
}
