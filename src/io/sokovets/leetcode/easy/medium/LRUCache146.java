package io.sokovets.leetcode.easy.medium;

import java.util.*;


    //Map<Key, ListNode> и ListNode как двунаправленный список, чтобы удаление было за O(1) и еще  head and tail на этот список
public class LRUCache146 {

    public static void main(String[] args) {
        /**
         * ["LRUCache","get","put","get","put","put","get","get"]
         * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
         */
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.get(2);
        lruCache.put(3, 2);
        lruCache.get(2);
        lruCache.get(3);

        System.out.println();
      //  lruCache.get(2);
       // lruCache.get(2);
    }
}

class LRUCache {

    int capacity;
    Map<Integer, Integer> cache;
    Deque<Map.Entry<Integer, Integer>> queue;

    //[[2], [1, 1], [2, 2], [1], [3, 3], [2, 5], [5], [4, 4], [1], [3], [4]]


    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>();
        this.queue = new LinkedList<>();
        this.capacity = capacity;

    }


    public int get(int key) {

        if (cache.containsKey(key)) {
            int value = cache.get(key);
            Map.Entry<Integer, Integer> pair = Map.entry(key, value);
            if (!queue.isEmpty() && !queue.getLast().equals(pair)) {

                //!!
                queue.remove(pair);
                queue.add(pair);
            }
            return value;
        }
        return -1;
    }


    public void put(int key, int value) {
        if (cache.size() < capacity) {
            if (cache.containsKey(key)) {
                int oldValue = cache.get(key);

                //!! O(N)
                queue.remove(Map.entry(key, oldValue));
            }
            cache.put(key, value);
            queue.add(Map.entry(key, value));

        } else {
            if (cache.containsKey(key)) {
                int oldValue = cache.get(key);

                //!!
                queue.remove(Map.entry(key, oldValue));

                queue.add(Map.entry(key, value));
                cache.put(key, value);
            } else {
                Map.Entry<Integer, Integer> pair = queue.pollFirst();
                cache.remove(pair.getKey());
                cache.put(key, value);
                queue.add(Map.entry(key, value));
            }
        }

    }


}


/**
 * class LRUCache {
 * <p>
 * //<Key, Map<Value, Queue>
 * //Map<Integer,Map<Integer,Integer>
 * <p>
 * int capacity;
 * Map<Integer, Integer> cache;
 * Deque<Integer> queue;
 * <p>
 * public LRUCache(int capacity) {
 * this.cache = new LinkedHashMap<>();
 * this.queue = new LinkedList<>();
 * this.capacity = capacity;
 * <p>
 * }
 * <p>
 * public int get(int key) {
 * if (cache.containsKey(key)) {
 * int value = cache.get(key);
 * if (queue.getLast() != value) {
 * queue.remove(value);
 * queue.addLast(value);
 * }
 * return value;
 * }
 * return -1;
 * }
 * <p>
 * <p>
 * public void put(int key, int value) {
 * if (cache.size() < capacity) {
 * if (!cache.containsKey(key)) {
 * cache.put(key, value);
 * queue.addLast(value);
 * } else {
 * Integer oldValue = cache.get(key);
 * cache.put(key, value);
 * queue.remove(oldValue);
 * queue.addLast(value);
 * }
 * // cache.put(key, value);
 * // queue.addLast(value); //2,3,1
 * } else {
 * if (cache.containsKey(key)) {
 * Integer oldValue = cache.get(key);
 * cache.put(key, value);
 * queue.remove(oldValue);
 * queue.addLast(value);
 * return;
 * }
 * <p>
 * <p>
 * int valueToDelete = queue.pollFirst(); // такое значение может быть у многих. Нужно искать
 * for (Map.Entry<Integer, Integer> entry : cache.entrySet()) //Здесь нужно искать не по первому вхождению значения а по ключу еще
 * {
 * if (valueToDelete == entry.getValue()) {
 * int keyToDelete = entry.getKey();
 * cache.remove(keyToDelete);
 * //System.out.println(cache);
 * break;
 * }
 * }
 * <p>
 * cache.put(key, value);
 * queue.addLast(value);
 * }
 * }
 * }
 **/
