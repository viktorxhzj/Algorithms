import java.util.ArrayList;

public class LC22 {
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> generateParenthesis(int n) {
        add(n, n, new StringBuilder());
        return res;
    }

    public void add(int left, int right, StringBuilder bd) {
        if (left == 0 && right == 0) {
            res.add(bd.toString());
            return ;
        }

        if (left == 0) {
            bd.append(")");
            add(left, right - 1, bd);
            bd.deleteCharAt(bd.length() - 1);
        }
        else if (left == right) {
            bd.append("(");
            add(left - 1, right, bd);
            bd.deleteCharAt(bd.length() - 1);
        }
        else {
            bd.append("(");
            add(left - 1, right, bd);
            bd.deleteCharAt(bd.length() - 1);
            bd.append(")");
            add(left, right - 1, bd);
            bd.deleteCharAt(bd.length() - 1);
        }
    }
}
