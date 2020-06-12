package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC210I {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Deque<Integer> q = new LinkedList<>();

        /* 邻接链表 */
        List<List<Integer>> adjacency = new ArrayList<>();

        /* 入度表 */
        int[] inDegree = new int[numCourses];

        /* 选课结果 */
        int[] ans = new int[numCourses];
        int ptr = 0;

        for (int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());

        for (int[] pair: prerequisites) {
            inDegree[pair[0]]++;
            adjacency.get(pair[1]).add(pair[0]);
        }



        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int i = q.poll();
            ans[ptr++] = i;
            numCourses--;
            for (int next: adjacency.get(i)) {
                inDegree[next]--;
                if (inDegree[next] == 0) q.add(next);
            }
        }
        return numCourses == 0? ans: new int[]{};
    }
}
