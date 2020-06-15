package leetcode;

import datastructure.Node;

public class LC138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node nxt = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = nxt;
            cur = nxt;
        }
        cur = head;
        while (cur != null) {
            Node nxt = cur.next.next;
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = nxt;
        }

        Node p1 = head, p2 = head.next;

        Node dummy = new Node(-1);
        dummy.next = p2;

        while (p2.next != null) {
            p1.next = p2.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = null;
        return dummy.next;
    }
}
