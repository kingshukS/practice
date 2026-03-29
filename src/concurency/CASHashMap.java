package concurency;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class CASHashMap<K, V> {
    private volatile AtomicReferenceArray<Node<K, V>> table;
    private static final int DEFAULT_CAPACITY = 16;

    static class Node<K, V> {
        final int hash;
        final K key;
        volatile V value;
        volatile Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public CASHashMap() {
        table = new AtomicReferenceArray<>(DEFAULT_CAPACITY);
    }

    private int spread(int h) {
        return (h ^ (h >>> 16)) & 0x7fffffff;
    }

    public V put(K key, V value) {
        int hash = spread(key.hashCode());
        AtomicReferenceArray<Node<K, V>> tab = table;
        int n = tab.length();
        int index = hash & (n - 1);
        for (;;) {
            Node<K, V> first = tab.get(index);
            if (first == null) {
                // Empty bucket - try CAS
                Node<K, V> newNode = new Node<>(hash, key, value, null);
                if (tab.compareAndSet(index, null, newNode)) {
                    return null;  // Successfully added
                }
                // CAS failed, retry
                continue;
            }

            // Non-empty bucket - synchronize on first node
            synchronized (first) {

                // Traverse and update or append
                for (Node<K, V> node = first; ; ) {
                    if (node.hash == hash && key.equals(node.key)) {
                        V oldValue = node.value;
                        node.value = value;
                        return oldValue;
                    }

                    Node<K, V> next = node.next;
                    if (next == null) {
                        node.next = new Node<>(hash, key, value, null);
                        return null;
                    }
                    node = next;
                }
            }
        }
    }

    public V get(K key) {
        int hash = spread(key.hashCode());
        AtomicReferenceArray<Node<K, V>> tab = table;
        int n = tab.length();
        int index = hash & (n - 1);

        // Lock-free read - just traverse the chain
        for (Node<K, V> node = tab.get(index); node != null; node = node.next) {
            if (node.hash == hash && key.equals(node.key)) {
                return node.value;  // volatile read ensures visibility
            }
        }
        return null;
    }

    public V putIfAbsent(K key, V value) {
        int hash = spread(key.hashCode());
        int index = hash & (table.length() - 1);

        for (;;) {
            Node<K, V> first = table.get(index);

            if (first == null) {
                Node<K, V> newNode = new Node<>(hash, key, value, null);
                if (table.compareAndSet(index, null, newNode)) {
                    return null;  // Inserted
                }
                continue;  // Retry
            }

            synchronized (first) {
                if (table.get(index) != first) continue;

                // Check if key exists
                for (Node<K, V> node = first; ; ) {
                    if (node.hash == hash && key.equals(node.key)) {
                        return node.value;
                    }

                    Node<K, V> next = node.next;
                    if (next == null) {
                        node.next = new Node<>(hash, key, value, null);
                        return null;
                    }
                    node = next;
                }
            }
        }
    }
}