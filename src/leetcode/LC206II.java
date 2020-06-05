package leetcode;

import datastructure.ListNode;

public class LC206II {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;

            // 指向先驱节点
            cur.next = pre;

            // 更新先驱节点
            pre = cur;
            // 更新当前节点
            cur = nxt;
        }
        // 当当前节点为空时，先驱节点则是原尾节点，如今头节点
        return pre;
    }
}
