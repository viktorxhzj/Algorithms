import java.util.*;

/**
 * 剑指59—II
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 思路：单调双端队列
 */
class JZ59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) return new int[0];
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> qMax = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
            // 那么为了维持从大到小的原则，我必须让尾部元素弹出
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i]) qMax.pollLast();

            // STEP 01 加尾
            // 不走 while 的话，说明我们正常在队列尾部添加元素
            qMax.addLast(i);

            // STEP 02 去头
            // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
            if (qMax.peekFirst() == (i - k)) qMax.pollFirst();

            // STEP 03 取最大值
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            if (i >= (k - 1)) res[index++] = nums[qMax.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        JZ59I test = new JZ59I();
        int[] temp = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        test.maxSlidingWindow(temp, 3);
    }
}

class JZ59II {

    LinkedList<Integer> maxList, list;

    public JZ59II() {
        list = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public int max_value() {
        return maxList.isEmpty() ? -1 : maxList.peekFirst();
    }

    public void push_back(int value) {
        list.offerLast(value);
        while (!maxList.isEmpty() && maxList.peekLast() < value) maxList.pollLast();
        maxList.offerLast(value);
    }

    public int pop_front() {
        int temp = list.isEmpty() ? -1 : list.pollFirst();
        if (temp != -1 && maxList.peekFirst() == temp) maxList.pollFirst();
        return temp;
    }
}
