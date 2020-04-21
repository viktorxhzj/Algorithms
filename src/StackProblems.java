import java.util.Stack;

/**
 * 剑指31
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 思路：对压入顺序进行遍历
 */
class JZ31 {
    public boolean validateStackSequences(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> s = new Stack<>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int value : pushA) {
            s.push(value);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!s.empty() && s.peek() == popA[popIndex]) {
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.isEmpty();
    }
}

/**
 * 剑指30
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中
 * 思路：辅助栈
 */
class JZ30 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) stack2.push(x);
        else if (stack2.peek() >= x) stack2.push(x);
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            int temp = stack1.pop();
            if (temp == stack2.peek()) stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}