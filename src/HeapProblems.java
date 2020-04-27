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