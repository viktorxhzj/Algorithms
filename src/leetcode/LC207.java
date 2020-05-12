package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC207 {
    List<List<Integer>> adjacency = new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());
        // 1 visited
        // 0 unvisited
        // -1 finished
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++) {
            if (flags[i] == 0 && !dfs(flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(int[] flags, int i) {

        // mark as visited
        flags[i] = 1;
        boolean res = true;
        for (int j: adjacency.get(i)) {
            if (flags[j] == 0) res = res && dfs(flags, j);
            if (flags[j] == 1) {
                res = false;
                break;
            }
        }

        // mark as finished
        flags[i] = -1;
        return res;
    }
}
