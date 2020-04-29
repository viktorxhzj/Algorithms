import java.util.*;

/**
 * Dijkstra算法：带非负值权重的有向图上单源最短路径问题
 *
 * 具体实现：使用邻近矩阵
 *
 * 输入要求：无边的权重为-1
 *
 * 时间复杂度：O(n^2)
 */
public class Dijkstra {

    private int len;
    private int[][] graph;
    private int sourcePos;
    private int[] distances;
    private boolean[] visited;

    public Dijkstra(int[][] graph, int sourcePos) {
        this.graph = graph;
        this.sourcePos = sourcePos;
        len = graph.length;
        distances = new int[len];
        Arrays.fill(distances, Integer.MAX_VALUE);
        visited = new boolean[len];
    }

    public void runDijkstra() {

        distances[sourcePos] = 0;

        while (true) {
            int smallestEst = Integer.MAX_VALUE;
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

        System.out.println("常规Dijkstra算法结果：");
        for (int i = 0; i < len; i++) {
            System.out.printf("节点%d到节点%d的距离为%d\n", sourcePos, i, distances[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[5][5];
        for (int[] ints : graph) {
            Arrays.fill(ints, -1);
        }
        graph[0][1] = 10;
        graph[0][2] = 5;
        graph[1][2] = 2;
        graph[1][3] = 1;
        graph[2][1] = 3;
        graph[2][3] = 9;
        graph[2][4] = 2;
        graph[3][4] = 4;
        graph[4][3] = 6;
        graph[4][0] = 7;
        Dijkstra algo = new Dijkstra(graph, 0);
        algo.runDijkstra();
    }
}
