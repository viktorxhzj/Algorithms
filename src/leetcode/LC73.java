package leetcode;

import java.util.Arrays;

public class LC73 {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }



        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) setRow(matrix, i);
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) setCol(matrix, j);
        }

        if (firstRow) setRow(matrix, 0);
        if (firstCol) setCol(matrix, 0);

    }


    public void setRow(int[][] matrix, int i) {
        Arrays.fill(matrix[i], 0);
    }

    public void setCol(int[][] matrix, int j) {
        for (int[] row: matrix) row[j] = 0;
    }
}
