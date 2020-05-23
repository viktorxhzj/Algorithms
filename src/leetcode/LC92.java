package leetcode;

import datastructure.ListNode;

public class LC92 {
    ListNode end;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        res.next = head;

        int pos = 0;

        while (pos != m - 1) {
            cur = cur.next;
            pos++;
        }
        ListNode temp = cur.next;
        cur.next = rev(temp, n - m);
        temp.next = end;

        return res.next;
    }

    public ListNode rev(ListNode node, int depth) {
        if (depth == 0) {
            end = node.next;
            return node;
        }
        ListNode returnNode = rev(node.next, depth - 1);
        node.next.next = node;
        node.next = null;
        return returnNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        LC92 algo = new LC92();
        ListNode res = algo.reverseBetween(head, 2, 4);
    }
}
