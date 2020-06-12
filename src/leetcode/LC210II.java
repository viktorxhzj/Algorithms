package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC210II {
    /* 邻接矩阵 */
    private List<List<Integer>> adjacency;

    /* 访问情况 */
    /* 0 - 未访问，1 - 当前访问，2 - 已访问 */
    private int[] visited;

    /* 选课结果 */
    private int[] ans;

    /* 无选课结果 */
    private final int[] wrongAns = new int[]{};

    private Deque<Integer> q;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        adjacency = new ArrayList<>();
        visited = new int[numCourses];
        ans = new int[numCourses];
        q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());

        for (int[] pair: prerequisites) {
            adjacency.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) if (!dfs(i)) return wrongAns;
        }

        for (int i = 0; i < numCourses; i++) ans[i] = q.removeLast();
        return ans;
    }

    public boolean dfs(int i) {
        if (visited[i] == -1) return true;
        if (visited[i] == 1) return false;

        visited[i] = 1;
        for (int next: adjacency.get(i)) {
            if (!dfs(next)) return false;
        }

        visited[i] = -1;
        q.addLast(i);
        return true;
    }
}
