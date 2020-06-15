package leetcode;

import datastructure.ListNode;

public class LC147 {
    ListNode dummy = new ListNode(Integer.MIN_VALUE);

    public ListNode insertionSortList(ListNode head) {
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            while (cur != null && cur.val >= pre.val) {
                pre = cur;
                cur = cur.next;
            }

            /* 此时 cur 小于 pre，将下个元素保存起来 */
            ListNode newStart = cur.next;

            /* 将 cur 断点 */
            cur.next = null;
            ListNode ptr = dummy;
            while (ptr.next != null) {
                ListNode nxt = ptr.next;
                if (nxt.val >= cur.val) {
                    ptr.next = cur;
                    cur.next = nxt;
                    break;
                }
                ptr = ptr.next;
            }
            cur = newStart;
            pre.next = cur;
        }


        return dummy.next;
    }
}
