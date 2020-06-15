package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC212 {
    private Set<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word: words) trie.add(word);

        for (String word: words) {
            char[] arr = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(trie, board, i, j);
                }
            }
        }
        return new ArrayList<>(set);

    }
    private void dfs(Trie trie, char[][] board, int i, int j) {
        if (trie.end) {
            set.add(trie.word);
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '.' || trie.nxts[board[i][j] -'a'] == null) return;
        trie = trie.nxts[board[i][j] -'a'];
        char temp = board[i][j];
        board[i][j] = '.';
        dfs(trie, board, i + 1, j);
        dfs(trie, board, i -1, j);
        dfs(trie, board, i, j + 1);
        dfs(trie, board, i, j - 1);
        board[i][j] = temp;
    }

    private static class Trie {
        Trie[] nxts = new Trie[26];
        boolean end;
        String word;

        Trie() {}

        public void add(String str) {
            Trie cur = this;

            for (char c: str.toCharArray()) {
                if (cur.nxts[c - 'a'] == null) {
                    cur.nxts[c - 'a'] = new Trie();
                }
                cur = cur.nxts[c - 'a'];
            }
            cur.word = str;
            cur.end = true;
        }
    }
}
