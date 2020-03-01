import java.util.ArrayList;
import java.util.Stack;

public class NowCoder {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 3, 4};
        int[] in = new int[]{4, 3, 2, 1};
        TreeNode test = NowCoder.reConstructBinaryTree(pre, in);
        System.out.println("END!");
    }
}
