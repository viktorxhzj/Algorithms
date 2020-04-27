
public class LC79 {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (hasPath(board, i, j, 0, arr)) return true;
            }
        }
        return false;
    }

    public boolean hasPath(char[][] board, int i, int j, int curPos, char[] word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[curPos]) return false;
        if (curPos == word.length - 1) return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean localRes =  hasPath(board, i + 1, j, curPos + 1, word) 
        || hasPath(board, i, j + 1, curPos + 1, word) 
        || hasPath(board, i - 1, j, curPos + 1, word) 
        || hasPath(board, i, j - 1, curPos + 1, word);
        board[i][j] = temp;
        return localRes;
    }
}