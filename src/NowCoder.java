import java.util.ArrayList;

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
}
