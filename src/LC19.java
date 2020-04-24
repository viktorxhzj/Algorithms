import datastructure.ListNode;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = new ListNode(-1);
        p1.next = head;
        ListNode p2 = p1;
        ListNode res = p1;
        for (int k = 0; k < n; k++) p2 = p2.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return res.next;
    }
}