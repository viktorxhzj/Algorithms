import java.util.ArrayList;

public class LC6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] cs = s.toCharArray();
        ArrayList<StringBuilder> arr = new ArrayList<>();
        for (int k = 0; k < numRows; k++) arr.add(new StringBuilder());
        int i = 0;
        boolean down = true;
        for (char ch: cs) {
            if (down) arr.get(i++).append(ch);
            else arr.get(i--).append(ch);
            if (i == numRows - 1 || i == 0) down = !down;
        }
        StringBuilder bd = new StringBuilder();
        for (int k = 0; k < numRows; k++) bd.append(arr.get(k));
        return bd.toString();
    }
}
