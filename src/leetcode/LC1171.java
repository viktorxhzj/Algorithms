package leetcode;

import datastructure.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LC1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            map.put(sum, node);
        }
        sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            node.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
