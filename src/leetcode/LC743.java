package leetcode;

import java.util.*;

public class LC743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N][N];
        for (int[] ints : graph) {
            /* 无边的权重为-1 */
            Arrays.fill(ints, -1);
        }
        /* 构造邻接矩阵 */
        for (int[] arr: times) {
            graph[arr[0] - 1][arr[1] - 1] = arr[2];
        }

        int res = dijkstra(graph, K - 1, N);
        return res == 101? -1: res;
    }

    private int dijkstra(int[][] graph, int sourcePos, int len) {
        int[] distances = new int[len];
        boolean[] visited = new boolean[len];

        Arrays.fill(distances, 101);

        distances[sourcePos] = 0;


        while (true) {
            int smallestEst = 101;
            int index = -1;
            for (int i = 0; i < len; i++) {
                if (!visited[i] && distances[i] < smallestEst) {
                    smallestEst = distances[i];
                    index = i;
                }
            }
            if (index == -1) break;
            visited[index] = true;
            for (int i = 0; i < len; i++) {
                if (graph[index][i] != -1 && (distances[i] > distances[index] + graph[index][i])) {
                    distances[i] = distances[index] + graph[index][i];
                }
            }
        }

        int maxD = 0;
        for (int dis: distances) {
            maxD = Math.max(maxD, dis);
        }
        return maxD;
    }
}