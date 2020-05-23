package leetcode;

import datastructure.ListNode;

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head, cur = head.next;
        ListNode nxt = new ListNode(-1);
        ListNode res = nxt;


        while (cur != null) {
            if (pre.val != cur.val) {
                nxt.next = pre;
                nxt = nxt.next;
                pre = cur;
                cur = cur.next;
            }
            else {
                while (cur != null && pre.val == cur.val) cur = cur.next;
                if (cur == null) {
                    pre = null;
                    break;
                }
                else {
                    pre = cur;
                    cur = cur.next;
                }
            }
        }
        nxt.next = pre;
        return res.next;
    }
}

class LC82II {
    public ListNode deleteDuplicates(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode oriNext = node.next;
        ListNode corNext = deleteDuplicates(node.next);
        if (node.val == oriNext.val) {
            if (corNext == null) return null;
            else if (node.val == corNext.val) return corNext.next;
            else return corNext;
        }
        else {
            node.next = corNext;
            return node;
        }
    }
}
