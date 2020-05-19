package leetcode;

import datastructure.ListNode;

public class LC328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p1 = head, p2 = head.next, p2Head = p2;

        while (p2 != null && p2.next != null) {
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = p2Head;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode a = head;
        a.next = new ListNode(1);
        a = a.next;
        a.next = new ListNode(2);
        a = a.next;
        a.next = new ListNode(3);
        a = a.next;
        a.next = new ListNode(4);
        a = a.next;
        a.next = new ListNode(5);
        LC328 algo = new LC328();
        ListNode res = algo.oddEvenList(head.next);
    }
}
