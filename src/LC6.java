import java.util.ArrayList;

public class LC6 {
    public String convert(String s, int numRows) {
        // 一行直接返回
        if (numRows == 1) return s;
        char[] cs = s.toCharArray();

        // 每一行都有一个StringBuilder
        ArrayList<StringBuilder> arr = new ArrayList<>();
        for (int k = 0; k < numRows; k++) arr.add(new StringBuilder());
        
        int i = 0;
        boolean down = true;

        for (char ch: cs) {
            // 如果下行，i++
            if (down) arr.get(i++).append(ch);
            // 如果上行，i--
            else arr.get(i--).append(ch);
            // 判断是否达到边界，切换上行/下行
            if (i == numRows - 1 || i == 0) down = !down;
        }
        
        StringBuilder bd = new StringBuilder();
        for (int k = 0; k < numRows; k++) bd.append(arr.get(k));
        return bd.toString();
    }
}
