package leetcode;

import java.util.LinkedList;

public class LC150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        int num;
        for (String str: tokens) {
            switch (str) {
                case "+":
                    num = stack.removeLast();
                    stack.addLast(stack.removeLast() + num);
                    break;
                case "-":
                    num = stack.removeLast();
                    stack.addLast(stack.removeLast() - num);
                    break;
                case "*":
                    num = stack.removeLast();
                    stack.addLast(stack.removeLast() * num);
                    break;
                case "/":
                    num = stack.removeLast();
                    stack.addLast(stack.removeLast() / num);
                    break;
                default:
                    num = Integer.parseInt(str);
                    stack.addLast(num);
                    break;
            }
        }
        return stack.peek();
    }
}
