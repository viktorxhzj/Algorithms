package leetcode;

import datastructure.ListNode;

public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        /* 计算链表长度 */
        int len = 0;
        ListNode ptr = dummy;
        while (ptr.next != null) {
            len++;
            ptr = ptr.next;
        }
        ptr.next = head;

        /* 计算要位移的长度 */
        k = k % len;
        if (k == 0) {
            ptr.next = null;
            return head;
        }
        k = len - k;

        ListNode pre = dummy, cur = head;

        while (k > 0) {
            pre = pre.next;
            cur = cur.next;
            k--;
        }
        ListNode newDummy = new ListNode(-1);
        newDummy.next = cur;
        pre.next = null;

        return newDummy.next;
    }
}
