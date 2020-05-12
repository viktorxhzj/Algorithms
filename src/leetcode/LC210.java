package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC210 {
    List<List<Integer>> adjacency = new ArrayList<>();
    Stack<Integer> list = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());
        // 1 visited
        // 0 unvisited
        // -1 finished
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++) {
            if (flags[i] == 0 && !dfs(flags, i)) return new int[]{};
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.pop();
        return res;
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
        list.push(i);
        return res;
    }
}
