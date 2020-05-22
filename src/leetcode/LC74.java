package leetcode;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;

        int left = 0, right = matrix.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) right = mid;
            else left = mid + 1;
        }
        if (left < m && matrix[left][0] == target) return true;
        int row = left - 1;
        left = 0;
        right = matrix[0].length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return matrix[row][left] == target;
    }
}
