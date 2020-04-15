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

/**
 * 剑指52
 * 输入两个链表，找出它们的第一个公共节点。
 * 思路：双指针
 */
class JZ52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0, countB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            a = a.next;
            countA++;
        }
        while (b != null) {
            b = b.next;
            countB++;
        }
        a = headA;
        b = headB;
        if (countA > countB) {
            for (int i = 0; i < countA - countB; i++) a = a.next;
        }
        if (countA < countB) {
            for (int i = 0; i < countB - countA; i++) b = b.next;
        }
        while (a != null && b != null) {
            if (a == b) return a;
            else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }
}

/**
 * LeetCode 2
 * Two Sum
 */
class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;

        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + carry) % 10);
            if (l1.val + l2.val + carry >= 10) carry = 1;
            else carry = 0;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            cur.next = new ListNode((l1.val + carry) % 10);
            if (l1.val + carry >= 10) carry = 1;
            else carry = 0;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.val + carry) % 10);
            if (l2.val + carry >= 10) carry = 1;
            else carry = 0;
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);


        return head.next;
    }
}

class LC445 {
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0;
        ListNode p = l1, q = l2;
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
        int dif = len1 - len2;
        ListNode head;
        if (dif == 0) {
            head = recur(p, q, 0, len1);
            if (carry == 0) return head;
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        else if (dif < 0) {
            for (int k = dif; k < 0; k++) q = q.next;
            ListNode pre = recur(l1, q, 0, len1);
            head = sRecur(l2, 0, -dif);
            q = head;
            while (q.next != null) q = q.next;
            q.next = pre;
        }
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        LC445 test = new LC445();
        ListNode res = test.addTwoNumbers(l1, l2);
        System.out.println("END");
    }
}