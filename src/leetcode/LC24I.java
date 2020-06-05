package leetcode;

import datastructure.ListNode;

public class LC24I {
    public ListNode swapPairs(ListNode node) {
        // 当当前节点为空或为尾节点时，可以当作头节点直接返回
        if (node == null || node.next == null) return node;

        // 将当前节点与返回的现有链表头节点粘合
        ListNode curHead = swapPairs(node.next.next);
        ListNode newHead = node.next;
        node.next = curHead;
        newHead.next = node;

        // 更新头节点并返回
        return newHead;
    }
}
