package leetcode;

import datastructure.ListNode;

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        /*
        pre -> 接下来k个节点的前驱节点
        end -> k个节点的尾节点
         */
        ListNode pre = dummy, end = dummy;

        /* 如果若干个k节点之后只剩一个节点，则直接返回 */
        while (end.next != null) {
            /* 找到接下来k个节点的尾节点 */
            for (int i = 0; i < k && end != null; i++) end = end.next;
            /* 如果尾节点为空/不到尾节点为空，则小于k个节点，返回 */
            if (end == null) break;

            /* 记录尾节点的下个节点 */
            ListNode nxt = end.next;
            /* 记录k个节点的首节点 */
            ListNode start = pre.next;

            /* 将尾节点的下个节点暂时置空，便于翻转链表时的终止条件的设定 */
            end.next = null;
            /* 反转这k个节点，返回的是翻转后的首节点，连在前驱节点之后 */
            pre.next = reverse(start);
            /* 原先k个节点的首节点在翻转后成为了尾节点，因此与原先尾节点的下个节点相连 */
            start.next = nxt;

            /* 更新前驱节点和尾节点指针，用于下一次遍历 */
            pre = start;
            end = start;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
