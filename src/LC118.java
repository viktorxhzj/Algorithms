import java.util.*;

public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if (i == 1) {
                list.add(row);
                continue;
            }
            for (int j = 1; j < i - 1; j++) {
                row.add(list.get(list.size() - 1).get(j - 1)+ list.get(list.size() - 1).get(j));
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}
