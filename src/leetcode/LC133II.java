package leetcode;

import datastructure.Node;

import java.util.*;

public class LC133II {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Deque<Node> queue = new LinkedList<>();
        visited.put(node, new Node(node.val, new ArrayList<>()));
        queue.addLast(node);
        while (!queue.isEmpty()) {
            int k = queue.size();
            while (k-- > 0) {
                Node origin = queue.removeFirst();
                Node clone = visited.get(origin);
                for (Node neighbor: origin.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        queue.addLast(neighbor);
                    }
                    clone.neighbors.add(visited.get(neighbor));
                }
            }
        }
        return visited.get(node);
    }
}
