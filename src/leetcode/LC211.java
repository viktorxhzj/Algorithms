package leetcode;

public class LC211 {
}

class WordDictionary {

    WordDictionary[] letters;
    boolean end;

    /** Initialize your data structure here. */
    public WordDictionary() {
        letters = new WordDictionary[26];
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.equals("")) return;
        char[] str = word.toCharArray();
        WordDictionary cur = this;
        for (char c: str) {
            if (cur.letters[c - 'a'] == null) cur.letters[c - 'a'] = new WordDictionary();
            cur = cur.letters[c - 'a'];
        }
        cur.end = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.equals("")) return false;
        return recur(this, word.toCharArray(), 0);
    }

    private boolean recur(WordDictionary dict, char[] str, int depth) {
        if (depth == str.length) {
            return dict.end;
        }

        int index = str[depth] - 'a';
        if (str[depth] != '.') {
            return dict.letters[index] != null && recur(dict.letters[index], str, depth + 1);
        }
        else {
            for (int i = 0; i < 26; i++) {
                if (dict.letters[i] == null) continue;
                if (recur(dict.letters[i], str, depth + 1)) return true;
            }
            return false;
        }
    }
}