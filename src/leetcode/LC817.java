package leetcode;

import datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC817 {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();

        for (int num: G) {
            set.add(num);
        }

        ListNode p1 = head;

        int count = 0;

        while (p1 != null) {
            if (!set.contains(p1.val)) {
                p1 = p1.next;
                continue;
            }
            while (p1 != null && set.contains(p1.val)) {
                p1 = p1.next;
            }
            count++;
        }

        return count;
    }
}
