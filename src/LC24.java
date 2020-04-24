import datastructure.ListNode;

public class LC24 {
    public ListNode swapPairsIterative(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        pre.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (true) {
            ListNode temp = p2.next;
            pre.next = p2;
            p2.next = p1;
            if (temp == null) {
                p1.next = null;
                break;
            }
            if (temp.next == null) {
                p1.next = temp;
                break;
            }
            pre = p1;
            p1 = temp;
            p2 = temp.next;
        }
        return res.next;
    }

    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode returnNode = head.next;
        head.next = swapPairsRecursive(head.next.next);
        returnNode.next = head;
        return returnNode;
    }
}