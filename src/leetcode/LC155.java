package leetcode;

import java.util.LinkedList;

public class LC155 {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    /** initialize your data structure here. */
    public LC155() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.offerLast(x);
        if (stack2.isEmpty()) stack2.offerLast(x);
        else if (x <= stack2.peekLast()) stack2.offerLast(x);
    }

    public void pop() {
        int top = stack1.pollLast();
        if (stack2.peekLast() == top) stack2.pollLast();
    }

    public int top() {
        return stack1.peekLast();
    }

    public int getMin() {
        return stack2.peekLast();
    }
}
