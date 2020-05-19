package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LC56 {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int i = 0, j = 1, k = 0;

        while (j < intervals.length) {
            if (!merge(intervals, i, j)) intervals[++i] = intervals[j++];
            else j++;
        }

        int[][] res = new int[i][];
        System.arraycopy(intervals, 0, res, 0, i + 1);
        return res;
    }

    public boolean merge(int[][] intervals, int i, int j) {
        if (intervals[j][0] > intervals[i][1]) return false;
        intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
        return true;
    }

    public static void main(String[] args) {
        LC56 algo = new LC56();
        int[][] matrix = {{8,10},{2,6},{1,3},{15,18}};
        int[][] res = algo.merge(matrix);
        System.out.println("pause");
    }
}
