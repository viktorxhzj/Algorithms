import datastructure.ListNode;

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return dnc(lists, 0, lists.length - 1);

    }

    public ListNode dnc(ListNode[] lists, int low, int high) {
        if (low == high) return lists[low];
        int mid = (low + high) / 2;
        ListNode left = dnc(lists, low, mid);
        ListNode right = dnc(lists, mid + 1, high);
        return merge(left, right);
    }

    public ListNode merge(ListNode p, ListNode q) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            }
            else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        if (p != null) cur.next = p;
        if (q != null) cur.next = q;
        return head.next;
    }
}
