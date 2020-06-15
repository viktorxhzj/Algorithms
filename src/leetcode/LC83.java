package leetcode;

import datastructure.ListNode;

public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-99999);
        dummy.next = head;

        ListNode pre = dummy, cur = head;

        while (cur != null) {
            if (cur.val == pre.val) {
                cur = cur.next;
                pre.next = cur;
            }
            else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
