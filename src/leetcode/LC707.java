package leetcode;

public class LC707 {
}

class MyLinkedList {

    Node dummyHead;
    Node dummyTail;
    int size;


    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummyHead = new Node(-1);
        dummyTail = new Node(-1);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) return -1;
        Node ptr = dummyHead;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        Node oldHead = dummyHead.next;

        dummyHead.next = node;
        node.pre = dummyHead;

        node.next = oldHead;
        oldHead.pre = node;

        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node oldTail = dummyTail.pre;

        oldTail.next = node;
        node.pre = oldTail;

        node.next = dummyTail;
        dummyTail.pre = node;

        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;

        Node ptr = dummyHead;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }

        Node nxt = ptr.next;
        Node node = new Node(val);

        ptr.next = node;
        node.pre = ptr;

        node.next = nxt;
        nxt.pre = node;

        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;

        Node ptr = dummyHead;

        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }

        Node nxt = ptr.next.next;

        ptr.next = nxt;
        nxt.pre = ptr;

        size--;
    }

    private static class Node {
        public Node pre;
        public Node next;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
