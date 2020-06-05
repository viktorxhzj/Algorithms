package leetcode;

import datastructure.ListNode;

public class LC206I {
    public ListNode reverseList(ListNode node) {
        // 终止条件：1. 当前节点为null，链表为空直接返回
        //          2. 当前节点为尾部节点，则当前节点为反转后的头节点，返回
        if (node == null || node.next == null) return node;

        // 拿到反转后的头节点
        ListNode cur = reverseList(node.next);

        // 原先的下一个节点已经是当前节点的父节点了
        node.next.next = node;
        // 当前节点的下个节点置空
        node.next = null;

        // 返回反转后的头节点
        return cur;
    }
}
