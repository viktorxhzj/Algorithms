import datastructure.ListNode;
import datastructure.Node;

/**
 * 剑指22
 * 链表中倒数第K个节点
 * 思路：距离双指针
 */
class JZ22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 1; i < k; i++) p1 = p1.next;
        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

}

/**
 * 剑指24
 * 反转链表
 * 思路：1）递归 2）双指针
 */
class JZ24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}

/**
 * 剑指25
 * 合并排序链表
 * 思路：一个索引指针
 */
class JZ25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return res.next;
    }
}

/**
 * 剑指35
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 思路：复制相同节点在节点之后
 */
class JZ35 {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node duplicate = new Node(cur.val);
            duplicate.next = cur.next;
            cur.next = duplicate;
            cur = duplicate.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random == null) cur.next.random = null;
            else cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node res = new Node(-1);
        Node Head = res;
        while (cur != null) {
            if (cur.next.next == null) {
                res.next = cur.next;
                cur.next = null;
                cur = null;

            }
            else {
                res.next = cur.next;
                res = res.next;
                cur.next = cur.next.next;
                cur = cur.next;
            }
        }
        return Head.next;
    }
}
