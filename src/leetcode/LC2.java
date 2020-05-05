package leetcode;

import datastructure.ListNode;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;

        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + carry) % 10);
            if (l1.val + l2.val + carry >= 10) carry = 1;
            else carry = 0;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            cur.next = new ListNode((l1.val + carry) % 10);
            if (l1.val + carry >= 10) carry = 1;
            else carry = 0;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.val + carry) % 10);
            if (l2.val + carry >= 10) carry = 1;
            else carry = 0;
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);

        return head.next;
    }
}
