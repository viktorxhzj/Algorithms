package leetcode;

import datastructure.ListNode;

public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-999);
        dummy.next = head;

        ListNode pre = dummy, cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            }
            else {
                pre = pre.next;
                cur = cur.next;
            }
        }



        return dummy.next;
    }
}
