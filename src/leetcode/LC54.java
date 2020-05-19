package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int status = 0, up = -1, down = matrix.length, left = -1, right = matrix[0].length;
        while ((down - up) > 1 && (right - left) > 1) {
            switch (status) {
                case 0:
                    for (int k = left + 1; k < right; k++) res.add(matrix[up + 1][k]);
                    up++;
                    status = 1;
                    break;
                case 1:
                    for (int k = up + 1; k < down; k++) res.add(matrix[k][right - 1]);
                    right--;
                    status = 2;
                    break;
                case 2:
                    for (int k = right - 1; k > left; k--) res.add(matrix[down - 1][k]);
                    down--;
                    status = 3;
                    break;
                case 3:
                    for (int k = down - 1; k > up; k--) res.add(matrix[k][left + 1]);
                    left++;
                    status = 0;
                    break;
            }
        }
        return res;
    }
}
