package leetcode;

import datastructure.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LC133I {
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) return visited.get(node);

        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        for (Node neighbor: node.neighbors) clone.neighbors.add(dfs(neighbor));

        /* clone Node */
        return clone;
    }
}
