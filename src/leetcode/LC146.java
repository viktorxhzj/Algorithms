package leetcode;

import java.util.HashMap;

public class LC146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));;
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}

class LRUCache {
    private final int CAPACITY;

    private HashMap<Integer, Deque.Node> map;
    private Deque queue;
    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        map = new HashMap<>();
        queue = new Deque();
    }

    public int get(int key) {
        // key不存在
        if (!map.containsKey(key)) return -1;
        Deque.Node node = map.get(key);
        int value = node.val;
        queue.moveToFirst(node);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Deque.Node node = map.get(key);
            node.val = value;
            queue.moveToFirst(node);
        }
        else {
            Deque.Node node = new Deque.Node(key, value);
            queue.addFirst(node);
            map.put(key, node);
            if (map.size() > CAPACITY) {
                Deque.Node removedNode = queue.removeLast();
                map.remove(removedNode.key);
            }
        }

    }

    static class Deque {
        Node dummyHead;
        Node dummyTail;

        public Deque() {
            dummyHead = new Node(-1, -1);
            dummyTail = new Node(-1, -1);
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        public void addFirst(Node node) {
            if (dummyHead.next == dummyTail) {
                dummyHead.next = node;
                node.pre = dummyHead;
                node.next = dummyTail;
                dummyTail.pre = node;
                return;
            }
            Node curHead = dummyHead.next;
            dummyHead.next = node;
            node.pre = dummyHead;
            node.next = curHead;
            curHead.pre = node;
        }

        public Node removeLast() {
            Node node = dummyTail.pre;
            dummyTail.pre = node.pre;
            node.pre.next = dummyTail;
            return node;
        }
        public void moveToFirst(Node node) {
            Node preNode = node.pre;
            preNode.next = node.next;
            node.next.pre = preNode;
            addFirst(node);
        }

        static class Node {
            public int key;
            public int val;
            public Node pre;
            public Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}