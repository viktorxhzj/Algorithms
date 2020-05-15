package leetcode;

public class LC208 {

}

class Trie {
    boolean end;
    Trie[] nexts = new Trie[26];
    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        Trie cur = this;

        for (char c: word.toCharArray()) {
            if (cur.nexts[c - 'a'] == null) {
                cur.nexts[c - 'a'] = new Trie();
            }
            cur = cur.nexts[c - 'a'];
        }
        cur.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        Trie cur = this;

        for (char c: word.toCharArray()) {
            if (cur.nexts[c - 'a'] == null) return false;
            cur = cur.nexts[c - 'a'];
        }
        return cur.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        Trie cur = this;

        for (char c: prefix.toCharArray()) {
            if (cur.nexts[c - 'a'] == null) return false;
            cur = cur.nexts[c - 'a'];
        }
        return true;
    }
}