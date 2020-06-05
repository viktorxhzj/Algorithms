package leetcode;

import datastructure.Node;

public class LC117 {
    public Node connect(Node node) {
        if (node == null || (node.left == null && node.right == null)) return node;
        if (node.left != null && node.right != null) {
            node.left.next = node.right;
            node.right.next = getNext(node);
        }
        else if (node.left != null) {
            node.left.next = getNext(node);
        }
        else {
            node.right.next = getNext(node);
        }
        connect(node.right);
        connect(node.left);
        return node;
    }

    private Node getNext(Node root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }
}
