package leetcode;

import datastructure.ListNode;

public class LC445 {
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0;
        ListNode p = l1, q = l2;

        // 求得两个链表的长度
        while (p != null && q != null) {
            len1++;
            len2++;
            p = p.next;
            q = q.next;
        }
        while (p != null) {
            len1++;
            p = p.next;
        }
        while (q != null) {
            len2++;
            q = q.next;
        }
        p = l1;
        q = l2;

        // 计算长度差
        int dif = len1 - len2;
        ListNode head;

        // 如果一样长，递归生成节点，节点为两个链表各自节点的和
        if (dif == 0) {
            head = recur(p, q, 0, len1);
            if (carry == 0) return head;
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        // 如果l2链表长
        else if (dif < 0) {
            // 让l2链表的指针前进长度差的距离，使尾部对齐
            for (int k = dif; k < 0; k++) q = q.next;
            // 递归生成对齐部分的新节点
            ListNode pre = recur(l1, q, 0, len1);
            // 单独递归生成只剩l2链表时的新节点
            head = sRecur(l2, 0, -dif);
            // 连接两个新生成的链表
            q = head;
            while (q.next != null) q = q.next;
            q.next = pre;
        }
        // 如果l1链表长
        else {
            for (int k = 0; k < dif; k++) p = p.next;
            ListNode pre = recur(p, l2, 0, len2);
            head = sRecur(l1, 0, dif);
            p = head;
            while (p.next != null) p = p.next;
            p.next = pre;
        }
        if (carry == 0) return head;
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return newHead;
    }

    public ListNode recur(ListNode l1, ListNode l2, int depth, int length) {
        if (depth == length) return null;
        ListNode next = recur(l1.next, l2.next, depth + 1, length);
        int res = l1.val + l2.val + carry;
        if (res >= 10) {
            carry = 1;
            res %= 10;
        }
        else carry = 0;
        ListNode cur = new ListNode(res);
        cur.next = next;
        return cur;
    }

    public ListNode sRecur(ListNode node, int depth, int length) {
        if (depth == length) return null;
        ListNode next = sRecur(node.next, depth + 1, length);
        int res = node.val + carry;
        if (res >= 10) {
            carry = 1;
            res %= 10;
        }
        else carry = 0;
        ListNode cur = new ListNode(res);
        cur.next = next;
        return cur;
    }
}
