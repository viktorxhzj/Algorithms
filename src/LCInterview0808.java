import java.util.ArrayList;
import java.util.HashSet;

public class LCInterview0808 {
    ArrayList<String> list = new ArrayList<>();
    public String[] permutation(String S) {
        char[] str = S.toCharArray();
        backTrack(str, 0, new StringBuilder(S.length()));
        return list.toArray(new String[0]);
    }

    public void backTrack(char[] str, int depth, StringBuilder bd) {
        if (depth == str.length) {
            list.add(bd.toString());
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int k = depth; k < str.length; k++) {
            if (set.contains(str[k])) continue;
            set.add(str[k]);
            swap(str, depth, k);
            bd.append(str[depth]);
            backTrack(str, depth + 1, bd);
            bd.deleteCharAt(bd.length() - 1);
            swap(str, depth, k);
        }
    }
    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
