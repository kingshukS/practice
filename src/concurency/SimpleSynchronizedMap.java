package concurency;

import java.util.concurrent.locks.ReentrantLock;

public class SimpleSynchronizedMap<K,V>{
    private final SimpleHashMap<K,V> map;
    private final ReentrantLock lock = new ReentrantLock();

    public SimpleSynchronizedMap(int capacity) {
        map = new SimpleHashMap<>(capacity);
    }

    public SimpleSynchronizedMap() {
        map = new SimpleHashMap<>();
    }

    public V put(K key, V value) {
        lock.lock();
        try {
            return map.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public V get(K key) {
        lock.lock();
        try {
            return map.get(key);
        } finally {
            lock.unlock();
        }
    }

    public V remove(K key) {
        lock.lock();
        try {
            return map.remove(key);
        }finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return map.size();
        }finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        lock.lock();
        try {
            if (map.size() == 0) {
                return true;
            }else  {
                return false;
            }
        }finally {
            lock.unlock();
        }
    }

    public V putIfAbsent(K key, V value) {
        lock.lock();
        try {
            V v = map.get(key);
            if (v == null) {
                map.put(key, value);
            }
            return v;
        }finally {
            lock.unlock();
        }
    }
}
