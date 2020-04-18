import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指29
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 思路：旋转矩阵
 */
class JZ29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int i = 0;
        while (matrix.length > 1) {
            for (int num: matrix[0]) {
                res[i] = num;
                i++;
            }
            matrix = spingMatrix(matrix);
        }
        for (int num: matrix[0]) {
            res[i] = num;
            i++;
        }
        return res;
    }
    public int[][] spingMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length - 1];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[matrix[0].length - 1 - j][i - 1] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
