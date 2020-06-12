package leetcode;

import java.util.*;

public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        /* 所有单词的集合 */
        Set<String> wordSet = new HashSet<>(wordList);

        /* 记录已经访问的单词 */
        Set<String> visited = new HashSet<>();

        /* 用于BFS的队列 */
        Deque<String> queue = new LinkedList<>();
        queue.addLast(beginWord);
        int len = 0;

        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            while (size-- > 0) {
                String str = queue.removeFirst();
                if (str.equals(endWord)) return len;

                /* 对每个单词，生成所有可能的邻居 */
                List<String> neighbors = neighbor(str);
                for (String neighbor: neighbors) {
                    if (neighbor.equals(endWord)) {
                        return len + 1;
                    }

                    /* 如果邻居单词存在于单词集合中并且没有被访问过，加入队列 */
                    if (wordSet.contains(neighbor) && !visited.contains(neighbor)) {
                        queue.addLast(neighbor);
                        visited.add(neighbor);
                    }
                }

            }
        }


        return 0;
    }

    private List<String> neighbor(String cur) {
        List<String> total = new ArrayList<>();
        char[] str = cur.toCharArray();
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < 26; j++) {
                char tmp = str[i];
                str[i] = (char) ('a' + j);
                if (str[i] != tmp) total.add(new String(str));
                str[i] = tmp;
            }
        }
        return total;
    }

}
