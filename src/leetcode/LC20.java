package leetcode;

import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        char[] brackets = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char bracket: brackets) {
            if (bracket == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.push(bracket);
            }
            else if (bracket == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else stack.push(bracket);
            }
            else if (bracket == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else stack.push(bracket);
            }
            else stack.push(bracket);
        }
        return stack.isEmpty();
    }
}
