package com.kingshuk.tests.misc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRU {
    private final Map<Integer, Node> nodeMap;
    private final ReentrantReadWriteLock lock;
    private final int capacity;
    private final Node head;
    private final Node tail;
    private int counter;

    public LRU ( int capacity ) {
        this.capacity = capacity;
        head = new Node ();
        tail = new Node ();
        head.post = tail;
        tail.pre = head;
        nodeMap = new ConcurrentHashMap<> ();
        counter = 0;
        lock = new ReentrantReadWriteLock ();
    }

    public void put ( int key, int value ) {
        this.lock.writeLock ().lock ();
        try {
            Node node = nodeMap.get ( key );

            if ( node == null ) {
                Node newNode = new Node ( key, value );
                nodeMap.put ( key, newNode );
                addNode ( newNode );

                counter++;
                if ( counter > capacity ) {
                    Node tail = popTail ();
                    nodeMap.remove ( tail.key );
                    counter--;
                }
            } else {
                node.value = value;
                moveToHead ( node );
            }
        } finally {
            this.lock.writeLock ().unlock ();
        }
    }

    public int get ( int key ) {
        this.lock.readLock ().lock ();
        try {
            Node node = nodeMap.get ( key );
            if ( node == null )
                return - 1;
            moveToHead ( node );
            return node.value;
        } finally {
            this.lock.readLock ().unlock ();
        }
    }

    private void moveToHead ( Node node ) {
        removeNode ( node );
        addNode ( node );
    }

    private Node popTail () {
        Node pre = tail.pre;
        removeNode ( pre );
        return pre;
    }

    private void removeNode ( Node node ) {
        Node pre = node.pre;
        Node post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    private void addNode ( Node newNode ) {
        newNode.post = head.post;
        newNode.pre = head;

        head.post.pre = newNode;
        head.post = newNode;
    }

    private class Node {
        private int key;
        private int value;
        private Node pre;
        private Node post;

        public Node () {
        }

        public Node ( int key, int value ) {
            this.key = key;
            this.value = value;
        }
    }
}
