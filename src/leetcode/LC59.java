package leetcode;

public class LC59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = -1, down = n, left = -1, right = n, k = 1, status = 0;
        while ((down - up) > 1 && (right - left) > 1) {
            switch (status) {
                case 0:
                    for (int i = left + 1; i < right; i++) {
                        matrix[up + 1][i] = k++;
                    }
                    up++;
                    status = 1;
                    break;
                case 1:
                    for (int i = up + 1; i < down; i++) {
                        matrix[i][right - 1] = k++;
                    }
                    right--;
                    status = 2;
                    break;
                case 2:
                    for (int i = right - 1; i > left; i--) {
                        matrix[down - 1][i] = k++;
                    }
                    down--;
                    status = 3;
                    break;
                case 3:
                    for (int i = down - 1; i > up; i--) {
                        matrix[i][left + 1] = k++;
                    }
                    left++;
                    status = 0;
                    break;
            }
        }
        return matrix;
    }
}
