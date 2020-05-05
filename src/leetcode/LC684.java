package leetcode;

import java.util.ArrayList;

public class LC684 {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[] parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] edge: edges) {
            int p1 = findParent(edge[0], parents), p2 = findParent(edge[1], parents);
            if (p1 == p2) {
                list.add(edge);
                continue;
            }
            parents[p1] = p2;
        }
        return list.get(list.size() - 1);
    }

    // 寻找节点所在集合的代表节点
    public int findParent(int i, int[] parents) {
        // 如果节点的父节点为自身，则已找到所在集合的代表节点
        if (parents[i] == i) return i;

        // 如果节点的父节点不为自身，则递归寻找所在集合的代表节点，同时压缩父节点
        parents[i] = findParent(parents[i], parents);
        return parents[i];
    }
}
