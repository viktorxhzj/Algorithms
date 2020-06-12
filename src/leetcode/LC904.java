package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC904 {
    public int totalFruit(int[] tree) {

        int i = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int maxCount = 0;
        while (j < tree.length) {
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            if (map.size() > 2) {
                while (i < j) {
                    map.put(tree[i], map.get(tree[i]) - 1);
                    if (map.get(tree[i]) == 0) {
                        map.remove(tree[i]);
                        i++;
                        break;
                    }
                    i++;
                }
            }
            maxCount = Math.max(maxCount, j - i + 1);
            j++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        LC904 algo = new LC904();
        algo.totalFruit(new int[]{6, 2, 1, 1, 3, 6, 6});
    }
}
