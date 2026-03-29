package concurency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * Thread-safe HashMap using lock striping (segment-based locking).
 *
 * Thread Safety: Operations on different segments proceed in parallel.
 *                Operations on the same segment are serialized.
 * Performance: Up to 16x parallelism over synchronized HashMap.
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public class ConcurrentHashMap<K, V> {
    private static final int DEFAULT_SEGMENTS = 16;
    private static final int DEFAULT_CAPACITY_PER_SEGMENT = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private final Segment<K, V>[] segments;
    private final AtomicInteger totalSize = new AtomicInteger(0);

    @SuppressWarnings("unchecked")
    public ConcurrentHashMap() {
        this(DEFAULT_SEGMENTS, DEFAULT_CAPACITY_PER_SEGMENT);
    }

    @SuppressWarnings("unchecked")
    public ConcurrentHashMap(int numSegments, int capacityPerSegment) {
        // Ensure power of 2 for fast modulo
        numSegments = tableSizeFor(numSegments);
        segments = new Segment[numSegments];
        for (int i = 0; i < numSegments; i++) {
            segments[i] = new Segment<>(capacityPerSegment);
        }
    }

    // Hash spreading function
    private int spread(int h) {
        return (h ^ (h >>> 16)) & 0x7fffffff;
    }

    // Get segment for a key
    private Segment<K, V> segmentFor(K key) {
        int hash = spread(key.hashCode());
        int segmentIndex = hash & (segments.length - 1);
        return segments[segmentIndex];
    }

    /**
     * Associates the specified value with the specified key.
     * @return previous value, or null if no previous mapping
     */
    public V put(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        Segment<K, V> segment = segmentFor(key);
        V oldValue = segment.put(key, spread(key.hashCode()), value);
        if (oldValue == null) {
            totalSize.incrementAndGet();
        }
        return oldValue;
    }

    /**
     * Returns the value for the specified key, or null if not found.
     */
    public V get(K key) {
        if (key == null) throw new NullPointerException();
        return segmentFor(key).get(key, spread(key.hashCode()));
    }

    /**
     * Removes the mapping for the specified key.
     * @return previous value, or null if no mapping existed
     */
    public V remove(K key) {
        if (key == null) throw new NullPointerException();
        Segment<K, V> segment = segmentFor(key);
        V oldValue = segment.remove(key, spread(key.hashCode()));
        if (oldValue != null) {
            totalSize.decrementAndGet();
        }
        return oldValue;
    }

    /**
     * Inserts the value only if the key is not already present.
     * @return existing value if present, null if inserted
     */
    public V putIfAbsent(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        Segment<K, V> segment = segmentFor(key);
        V result = segment.putIfAbsent(key, spread(key.hashCode()), value);
        if (result == null) {
            totalSize.incrementAndGet();
        }
        return result;
    }

    /**
     * Computes the value if the key is not present.
     * The mapping function is called at most once.
     */
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        if (key == null || mappingFunction == null) throw new NullPointerException();
        Segment<K, V> segment = segmentFor(key);
        return segment.computeIfAbsent(key, spread(key.hashCode()), mappingFunction, totalSize);
    }

    /**
     * Returns true if the map contains the specified key.
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Returns the approximate number of entries.
     * May not be accurate during concurrent modifications.
     */
    public int size() {
        return totalSize.get();
    }

    /**
     * Returns true if the map contains no entries.
     */
    public boolean isEmpty() {
        return totalSize.get() == 0;
    }

    /**
     * Removes all entries from the map.
     */
    public void clear() {
        for (Segment<K, V> segment : segments) {
            segment.clear();
        }
        totalSize.set(0);
    }

    // Compute next power of 2 >= n
    private static int tableSizeFor(int n) {
        n = n - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

    // ==================== Inner Classes ====================

    private static class Segment<K, V> {
        private final ReentrantLock lock = new ReentrantLock();
        private Node<K, V>[] table;
        private int count;

        @SuppressWarnings("unchecked")
        Segment(int capacity) {
            table = new Node[capacity];
            count = 0;
        }

        V put(K key, int hash, V value) {
            lock.lock();
            try {
                int index = hash & (table.length - 1);

                for (Node<K, V> node = table[index]; node != null; node = node.next) {
                    if (node.hash == hash && key.equals(node.key)) {
                        V oldValue = node.value;
                        node.value = value;
                        return oldValue;
                    }
                }

                table[index] = new Node<>(hash, key, value, table[index]);
                count++;

                if (count > table.length * LOAD_FACTOR) {
                    resize();
                }

                return null;
            } finally {
                lock.unlock();
            }
        }

        V get(K key, int hash) {
            lock.lock();
            try {
                int index = hash & (table.length - 1);
                for (Node<K, V> node = table[index]; node != null; node = node.next) {
                    if (node.hash == hash && key.equals(node.key)) {
                        return node.value;
                    }
                }
                return null;
            } finally {
                lock.unlock();
            }
        }

        V remove(K key, int hash) {
            lock.lock();
            try {
                int index = hash & (table.length - 1);
                Node<K, V> prev = null;

                for (Node<K, V> node = table[index]; node != null; prev = node, node = node.next) {
                    if (node.hash == hash && key.equals(node.key)) {
                        if (prev == null) {
                            table[index] = node.next;
                        } else {
                            prev.next = node.next;
                        }
                        count--;
                        return node.value;
                    }
                }
                return null;
            } finally {
                lock.unlock();
            }
        }

        V putIfAbsent(K key, int hash, V value) {
            lock.lock();
            try {
                int index = hash & (table.length - 1);

                for (Node<K, V> node = table[index]; node != null; node = node.next) {
                    if (node.hash == hash && key.equals(node.key)) {
                        return node.value;
                    }
                }

                table[index] = new Node<>(hash, key, value, table[index]);
                count++;

                if (count > table.length * LOAD_FACTOR) {
                    resize();
                }

                return null;
            } finally {
                lock.unlock();
            }
        }

        V computeIfAbsent(K key, int hash, Function<? super K, ? extends V> mapper,
                         AtomicInteger totalSize) {
            lock.lock();
            try {
                int index = hash & (table.length - 1);

                for (Node<K, V> node = table[index]; node != null; node = node.next) {
                    if (node.hash == hash && key.equals(node.key)) {
                        return node.value;
                    }
                }

                V value = mapper.apply(key);
                if (value != null) {
                    table[index] = new Node<>(hash, key, value, table[index]);
                    count++;
                    totalSize.incrementAndGet();

                    if (count > table.length * LOAD_FACTOR) {
                        resize();
                    }
                }

                return value;
            } finally {
                lock.unlock();
            }
        }

        void clear() {
            lock.lock();
            try {
                for (int i = 0; i < table.length; i++) {
                    table[i] = null;
                }
                count = 0;
            } finally {
                lock.unlock();
            }
        }

        @SuppressWarnings("unchecked")
        private void resize() {
            Node<K, V>[] oldTable = table;
            int newCapacity = oldTable.length * 2;
            Node<K, V>[] newTable = new Node[newCapacity];

            for (Node<K, V> head : oldTable) {
                while (head != null) {
                    Node<K, V> next = head.next;
                    int newIndex = head.hash & (newCapacity - 1);
                    head.next = newTable[newIndex];
                    newTable[newIndex] = head;
                    head = next;
                }
            }

            table = newTable;
        }
    }

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}