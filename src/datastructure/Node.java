package datastructure;

import java.util.ArrayList;

public class Node {
    public int val;
    public Node next;
    public Node random;
    public Node left;
    public Node right;
    public ArrayList<Node> neighbors;
    public Node(int val) {
        this.val = val;
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}