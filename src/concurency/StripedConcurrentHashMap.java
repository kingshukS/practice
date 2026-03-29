package concurency;

import java.util.concurrent.locks.ReentrantLock;
import static concurency.SimpleHashMap.Node;

public class StripedConcurrentHashMap<K,V>{
    private static final int DEFAULT_NO_OF_SEGMENTS = 16;
    private static final int DEFAULT_CAPACITY_PER_SEGMENT = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Segment<K,V>[] segments;

    public StripedConcurrentHashMap() {
        new StripedConcurrentHashMap<K,V>(DEFAULT_NO_OF_SEGMENTS);
    }

    @SuppressWarnings("unchecked")
    public StripedConcurrentHashMap(int capacity) {
        segments = new Segment[capacity];
        for(int i = 0; i < segments.length; i++)
        {
            segments[i] = new Segment<>(DEFAULT_CAPACITY_PER_SEGMENT);
        }
    }

    private int hash(K key){
        int h = key.hashCode();
        return h ^ (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
    }

    private Segment<K,V> getSegment(K key){
        int hash = hash(key) >>> 28;
        int index = hash & (segments.length-1);
        return segments[index];
    }

    public V put(K key, V value) {
        return getSegment(key).put(hash(key), key, value);
    }

    public V get(K key) {
        return getSegment(key).get(hash(key), key);
    }

    public V remove(K key) {
        return getSegment(key).remove( hash(key), key);
    }

    public V putIfAbsent(K key, V value) {
        return getSegment(key).putIfAbsent(hash(key), key, value);
    }

    public int size() {
        int total = 0;
        for (Segment<K, V> segment : segments) {
            segment.lock.lock();
        }

        try {
            for (Segment<K, V> segment : segments) {
                total += segment.count;
            }
        } finally {
            // Unlock in reverse order (not strictly necessary but good practice)
            for (int i = segments.length - 1; i >= 0; i--) {
                segments[i].lock.unlock();
            }
        }

        return total;
    }

    private static class Segment<K,V>{
       private ReentrantLock lock = new ReentrantLock();
       private Node<K,V>[] table;
       private int count;

       @SuppressWarnings("unchecked")
       Segment(int capacity){
           table = new Node[capacity];
           count = 0;
       }

       private V put(int hash, K key, V value){
           lock.lock();
           try {
               int index = hash & (table.length-1);
               for(Node<K,V> node = table[index]; node != null; node = node.next){
                   if(node.hash == hash && node.key == key){
                       V oldValue = node.value;
                       node.value = value;
                       return oldValue;
                   }
               }
               table[index] = new Node<>(key,hash, value,  table[index]);
               count++;

               if(count > table.length*DEFAULT_LOAD_FACTOR){
                   resize();
               }
               return null;
           }finally {
               lock.unlock();
           }
       }

       private V get(int hash, K key){
           lock.lock();
           try {
               int index = hash & (table.length-1);
               for(Node<K,V> node = table[index]; node != null; node = node.next){
                   if(node.hash == hash && node.key == key){
                       return node.value;
                   }
               }
               return null;
           }finally {
               lock.unlock();
           }
       }

       private V remove(int hash, K key){
           lock.lock();
           try {
               int index = hash & (table.length-1);
               Node<K,V> node = table[index];
               Node<K,V> prev = null;
               while(node != null){
                   if(node.hash == hash && node.key == key){
                       if(prev == null){
                           table[index] = node.next;
                       }else{
                           prev.next = node.next;
                       }
                       count--;
                       return node.value;
                   }
                   prev = node;
                   node = node.next;
               }
               return null;
           }finally {
               lock.unlock();
           }
       }

       private V putIfAbsent(int hash, K key, V value){
           lock.lock();
           try {
               int index = hash & (table.length-1);
               for(Node<K,V> node = table[index]; node != null; node = node.next){
                   if(node.hash == hash && node.key == key){
                       return node.value;
                   }
               }
               table[index] = new Node<>(key,hash, value,  table[index]);
               count++;
               if(count > table.length*DEFAULT_LOAD_FACTOR){
                   resize();
               }
               return null;
           } finally {
               lock.unlock();
           }
       }

       @SuppressWarnings("unchecked")
       private void resize(){
           Node<K,V>[] oldTable = table;
           int newCapacity = table.length*2;
           Node<K,V>[] newTable = new Node[newCapacity];
           for(Node<K,V> head : oldTable){
               for(Node<K,V> node = head; node != null;){
                   int newIndex = node.hash & (newCapacity-1);
                   Node<K,V> next = node.next;
                   node.next = newTable[newIndex];
                   newTable[newIndex] = node;
                   node = next;
               }
           }
           table = newTable;
       }
    }
}
