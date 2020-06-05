package leetcode;

import datastructure.ListNode;

public class LC24II {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        // pre
        // cur
        // nxt
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null && cur.next != null) {
            ListNode nxt = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = null;
            pre = cur;
            cur = nxt;
        }
        pre.next = cur;
        return dummy.next;
    }
}
