package leetcode;

import datastructure.ListNode;

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int L1 = 0, L2 = 0, dif;
        ListNode p, q;

        p = headA;
        while (p != null) {
            L1++;
            p = p.next;
        }

        p = headB;
        while (p != null) {
            L2++;
            p = p.next;
        }

        if (L1 - L2 > 0) {
            p = headA;
            q = headB;
            dif = L1 - L2;
        }
        else {
            p = headB;
            q = headA;
            dif = L2 - L1;
        }

        for (int i = 0; i < dif; i++) {
            p = p.next;
        }

        while (p != null) {
            if (p == q) return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
