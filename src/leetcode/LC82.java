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

    public static void main(String[] args) {
        LC82 algo = new LC82();
//        [1,2,3,3,4,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        ListNode res = algo.deleteDuplicates(head);
        System.out.println(".");
    }
}
