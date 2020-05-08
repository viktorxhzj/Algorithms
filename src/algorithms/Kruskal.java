package algorithms;

import java.util.*;

public class Kruskal {

    private Edge[] edges;
    private int n;
    public Kruskal(int[][] graph, int n) {
        this.n = n;
        edges = new Edge[graph.length];
        for (int i = 0; i < graph.length; i++) {
            edges[i] = new Edge(graph[i][0], graph[i][1], graph[i][2]);
        }
    }

    public void runKruskal() {
        PriorityQueue<Edge> queue = new PriorityQueue<>(edges.length, new Edge()); // 给一个comparator实现类

        ArrayList<Edge> mst = new ArrayList<>();

        int[] parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;

        int[] size = new int[n];
        Arrays.fill(size, 1);

        for (Edge edge: edges) queue.offer(edge);
        while(!queue.isEmpty()) {
            Edge curEdge = queue.poll();
            if (findParent(curEdge.u, parents) == findParent(curEdge.v, parents)) continue;
            mst.add(curEdge);
            int node1 = findParent(curEdge.u, parents), node2 = findParent(curEdge.v, parents);
            if (size[node1] < size[node2]) {
                parents[node1] = parents[node2];
                size[node2] += size[node1];
            }
            else {
                parents[node2] = parents[node1];
                size[node1] += size[node2];
            }
        }
        for (Edge edge: mst) System.out.printf("%d, %d, %d\n", edge.u, edge.v, edge.weight);
    }

    public int findParent(int u, int[] parents) {
        if (parents[u] == u) return u;
        parents[u] = findParent(parents[u], parents);
        return parents[u];
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 4},
                {1, 3, 8},
                {2, 3, 11},
                {2, 5, 8},
                {3, 4, 7},
                {3, 6, 1},
                {4, 6, 6},
                {4, 5, 2},
                {5, 7, 4},
                {5, 8, 7},
                {7, 0, 10},
                {8, 0, 9},
                {8, 7, 14},
                {6, 7, 2}};
        Kruskal algo = new Kruskal(graph, 9);
        algo.runKruskal();
    }
}

class Edge implements Comparator<Edge> {
    public int u;
    public int v;
    public int weight;

    public Edge() {}

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }
}
