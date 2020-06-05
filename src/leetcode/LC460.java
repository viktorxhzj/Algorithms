package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC460 {}

class LFUCache {
    private final int CAPACITY;
    /* key-node */
    Map<Integer, Node> cache;

    /* frequency-nodelist */
    Map<Integer, Node[]> frequencies;

    int minFreq = 1;

    public LFUCache(int capacity) {
        CAPACITY = capacity;
        cache = new HashMap<>();
        frequencies = new HashMap<>();
    }

    public void removeFreq(Node node) {
        Node[] oldList = frequencies.get(node.usedTime);
        remove(node);
        if (minFreq == node.usedTime && oldList[0].next == oldList[1]) minFreq++;
        node.updateUsage();
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addFirst(Node node, Node head) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public void putFreq(Node node) {
        Node[] newList = frequencies.get(node.usedTime);
        if (newList == null) {
            newList = new Node[2];
            newList[0] = new Node();
            newList[1] = new Node();
            newList[0].next = newList[1];
            newList[1].pre = newList[0];
            addFirst(node, newList[0]);
            frequencies.put(node.usedTime, newList);
        }
        else {
            addFirst(node, newList[0]);
        }
    }


    public int get(int key) {
        if (CAPACITY == 0) return -1;

        Node node = cache.get(key);

        if (node == null) return -1;

        removeFreq(node);

        putFreq(node);

        return node.val;
    }

    public Node removeLast(Node tail) {
        Node node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        return node;
    }

    public void put(int key, int value) {
        if (CAPACITY == 0) return;

        Node node = cache.get(key);

        if (node == null) {
            if (cache.size() == CAPACITY) {
                Node[] list = frequencies.get(minFreq);
                Node removedNode = removeLast(list[1]);
                cache.remove(removedNode.key);
            }
            node = new Node(key, value);
            cache.put(key, node);
            minFreq = Math.min(minFreq, node.usedTime);

        }
        else {
            node.val = value;

            removeFreq(node);

        }
        putFreq(node);
    }
    static class Node {
        int key;
        int val;
        int usedTime;
        Node pre;
        Node next;

        public Node() {}

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            updateUsage();
        }

        public void updateUsage() {
            usedTime++;
        }
    }
}