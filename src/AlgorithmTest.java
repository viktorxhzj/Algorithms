import static org.junit.Assert.*;

import datastructure.ListNode;
import org.junit.*;

import java.util.List;
import java.util.PriorityQueue;


public class AlgorithmTest {
    @Test
    public void testLC23B() {
        LC23B test = new LC23B();
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);
        ListNode c = new ListNode(2);
        c.next = new ListNode(6);
        ListNode res = test.mergeKLists(new ListNode[]{a, b, c});
        System.out.println("PAUSE");
    }
    @Test
    public void testLC46() {
        LC46 test = new LC46();
//        List<List<Integer>> res = test.permute(new int[]{1, 2, 3});
//        System.out.println("END");
    }

    @Test
    public void testLC355() {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(1);
        q.offer(5);
        q.offer(3);
    }

    @Test
    public void testLC61() {
        LC61 test = new LC61();
        test.rotateRight(new ListNode(1), 0);
    }
}