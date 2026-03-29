package concurency;

public class SimpleHashMap<K,V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size = 0;
    private Node<K,V>[] table;
    public SimpleHashMap() {
        new SimpleHashMap<K,V>(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SimpleHashMap(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);

        table = new Node[initialCapacity];
    }

    public V put(K key, V value) {
        int hash = hash(key);
        int index = hash & table.length - 1;

        for(Node<K,V> node = table[index]; node != null; node = node.next) {
            if (node.hash == hash && node.key.equals(key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        Node<K,V> newNode = new Node<>(key, hash, value, table[index]);
        table[index] = newNode;
        size++;

        if(size > table.length * DEFAULT_LOAD_FACTOR) {
            // Need to resize
            resize();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K,V>[] oldTable = table;
        int newCapacity = oldTable.length * 2;
        Node<K,V>[] newTable = new Node[newCapacity];
        for(Node<K,V> head : oldTable) {
            for(Node<K,V> node = head; node != null;) {
                int newIndex = node.hash & (newCapacity-1);
                Node<K,V> next = node.next;
                node.next = newTable[newIndex];
                newTable[newIndex] = node;
                node = next;
            }
        }
        table = newTable;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = hash & table.length - 1;
        for (Node<K,V> node = table[index]; node != null; node = node.next) {
            if (node.hash == hash && node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        int index = hash & table.length - 1;
        Node<K,V> node = table[index];
        Node<K,V> prev = null;
        while (node != null) {
            if (node.hash == hash && node.key.equals(key)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        
        return null;
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    static class Node<K,V> {
        final K key;
        final int hash;
        V value;
        Node<K,V> next;

        Node(K key, int hash, V value, Node<K,V> next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }
    }
}
