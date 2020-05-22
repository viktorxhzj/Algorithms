package leetcode;

import java.util.Stack;

public class LC901 {
    Stack<int[]> pairs;

    public LC901() {
        pairs = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!pairs.isEmpty() && pairs.peek()[1] <= price) {
            int[] pair = pairs.pop();
            w += pair[0];
        }

        pairs.push(new int[]{w, price});
        return w;
    }
}
