import java.util.ArrayList;
import java.util.Stack;

public class NowCoder {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * Traversal
     * O(n+m)
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        int rows = array.length - 1;
        int cols = array[0].length - 1;
        int i = rows;
        int j = 0;
        while ((i >= 0) && (j <= cols))
        {
            if (array[i][j] == target) {
                return true;
            }
            else if (array[i][j] > target) {
                i--;
            }
            else {
                j++;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * Traversal
     * O(n)
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuilder help = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                help.append("%20");
            }
            else {
                help.append(str.charAt(i));
            }
        }
        return help.toString();
    }

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     * Recursive
     * O(n)
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> reverseList = new ArrayList<>();
        NowCoder.helper(reverseList, listNode);
        return reverseList;
    }
    public static void helper(ArrayList<Integer> list, ListNode listNode) {
        if (listNode.next != null) {
            helper(list, listNode.next);
        }
        list.add(listNode.val);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * Recursive
     * O(logn)
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }
        int i = 0;
        while (in[i] != pre[0]) {
            i++;
        }
        if (i == in.length - 1) {
            int[] leftPreArray = new int[i];
            int[] leftInArray = new int[i];
            System.arraycopy(pre, 1, leftPreArray, 0, i);
            System.arraycopy(in, 0, leftInArray, 0, i);
            root.left = reConstructBinaryTree(leftPreArray, leftInArray);
            return root;
        }
        else if (i == 0) {
            int[] rightPreArray = new int[pre.length - 1];
            int[] rightInArray = new int[pre.length - 1];
            System.arraycopy(pre, i + 1, rightPreArray, 0, pre.length - i - 1);
            System.arraycopy(in, i + 1, rightInArray, 0, pre.length - i - 1);
            root.right = reConstructBinaryTree(rightPreArray, rightInArray);
            return root;
        }


        int[] leftPreArray = new int[i];
        int[] leftInArray = new int[i];
        int[] rightPreArray = new int[pre.length - i - 1];
        int[] rightInArray = new int[pre.length - i - 1];

        System.arraycopy(pre, 1, leftPreArray, 0, i);
        System.arraycopy(in, 0, leftInArray, 0, i);
        System.arraycopy(pre, i + 1, rightPreArray, 0, pre.length - i - 1);
        System.arraycopy(in, i + 1, rightInArray, 0, pre.length - i - 1);
        root.left = reConstructBinaryTree(leftPreArray, leftInArray);
        root.right = reConstructBinaryTree(rightPreArray, rightInArray);
        return root;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
             val = x;
        }
    }

    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     * Traversal
     * O(n)
     */
    public static class MyQueue {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            this.stack1.push(node);

        }

        public int pop() {
            while (!this.stack1.empty()) {
                this.stack2.push(this.stack1.pop());
            }
            int temp = this.stack2.pop();
            while (!this.stack2.empty()) {
                this.stack1.push(this.stack2.pop());
            }
            return temp;
        }
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            if (array[0] >= array[1]) {
                return array[1];
            }
            else {
                return 0;
            }
        }
        return helper(array, 0, array.length - 1);
    }
    public static int helper(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] < arr[mid - 1]) {
            return arr[mid];
        }
        if (arr[mid] >= arr[0]) {
            return helper(arr, mid + 1, high);
        }
        else {
            return helper(arr, low, mid - 1);
        }
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] list = new int[n + 1];
        list[0] = 0;
        list[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        return list[n];
    }


    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int[] list = new int[target];
        list[0] = 1;
        list[1] = 2;
        for (int i = 2; i < target; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        return list[target - 1];
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 4, 5, 1, 2};
        int[] in = new int[]{4, 3, 2, 1};
        int res = NowCoder.minNumberInRotateArray(pre);
    }
}
