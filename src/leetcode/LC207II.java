package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC207II {
    /* 邻接矩阵 */
    List<List<Integer>> adjacency = new ArrayList<>();

    /* 访问情况 */
    /* 0 - 未访问，1 - 当前访问，2 - 已访问 */
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());

        for (int[] pair: prerequisites) {
            adjacency.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) if (!dfs(i)) return false;
        }

        return true;
    }

    public boolean dfs(int i) {
        if (visited[i] == -1) return true;
        if (visited[i] == 1) return false;

        visited[i] = 1;
        for (int next: adjacency.get(i)) {
            if (!dfs(next)) return false;
        }

        visited[i] = -1;
        return true;
    }
}
