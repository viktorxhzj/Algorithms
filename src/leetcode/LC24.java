package leetcode;

import datastructure.ListNode;

public class LC24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode returnNode = head.next;
        head.next = swapPairs(head.next.next);
        returnNode.next = head;
        return returnNode;
    }
}
