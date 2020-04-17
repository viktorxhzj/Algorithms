import datastructure.ListNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指41
 * 如何得到一个数据流中的中位数？
 * 思路：维护一个大顶堆和一个小顶堆
 */
class JZ41 {

    private PriorityQueue<Integer> maxHeap, minHeap;

    public JZ41() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        //如果不平衡则调整
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
        return maxHeap.peek();
    }
}

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 思路：最大堆
 * 时间复杂度：nlogk
 */
class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        for (ListNode node: lists) {
            if (node != null) heap.offer(node);
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (!heap.isEmpty()) {
            cur.next = heap.poll();
            if (cur.next.next != null) heap.offer(cur.next.next);
            cur = cur.next;
        }
        return head.next;
    }
}