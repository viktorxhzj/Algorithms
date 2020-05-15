package leetcode;

public class LC48 {
    public void rotate(int[][] matrix) {
        int i = 0, len = matrix.length;
        while (i <= (len - 1) / 2) {
            for (int j = i; j < len - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        LC48 algo = new LC48();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        algo.rotate(matrix);
    }
}
