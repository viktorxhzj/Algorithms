package leetcode;

import java.util.*;

public class LC547 {
    public int findCircleNum(int[][] M) {
        if (M.length == 0) return 0;
        if (M.length == 1) return 1;

        // 集合节点
        int[] parent = new int[M.length];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        // 集合数量
        int[] size = new int[M.length];
        Arrays.fill(size, 1);

        for (int i = 0; i < M.length - 1; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    int pi = findParent(i, parent), pj = findParent(j, parent);
                    if (size[pi] > size[pj]) {
                        parent[pj] = pi;
                        size[pi] += size[pj];
                    }
                    else {
                        parent[pi] = pj;
                        size[pj] += size[pi];
                    }
                }
            }
        }
        int count = M.length;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != i) count--;
        }
        return count;

    }

    public int findParent(int i, int[] parent) {
        while (parent[i] != i) {
            // 进行路径压缩
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
