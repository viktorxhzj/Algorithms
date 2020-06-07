package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC42II {
    public int trap6(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();

        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[current] > height[stack.peekLast()]) {
                int h = height[stack.peekLast()]; //取出要出栈的元素
                stack.removeLast(); //出栈
                if (stack.isEmpty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peekLast() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peekLast()], height[current]);
                sum += + distance * (min - h);
            }
            stack.addLast(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }
}
