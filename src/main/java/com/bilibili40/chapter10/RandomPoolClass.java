package com.bilibili40.chapter10;

import org.junit.Test;

import java.util.HashMap;

/**
 * @date 2023-03-16 15:07
 * inset(key) delete(key) getRandom() 均为 O(1)
 */
public class RandomPoolClass {
    @Test
    public void test() {
        Pool<Character> pool = new Pool<>();
        pool.insert('A');
        System.out.println(pool.size);
        pool.insert('B');
        System.out.println(pool.size);
        pool.insert('C');
        System.out.println(pool.size);
        System.out.println(pool.getRandom());
        pool.delete('B');
        System.out.println(pool.size);
    }

    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size; //0 ~ size-1

        public Pool() {
            this.indexKeyMap = new HashMap<>();
            this.keyIndexMap = new HashMap<>();
            this.size = 0;
        }

        public void insert(K key) {
            if (!keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, size);
                this.indexKeyMap.put(size, key);
                ++size;
            }
        }

        public void delete(K key) {
            if (keyIndexMap.containsKey(key)) {
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                //调整 删除key-deleteIndex，将最后一条调整为lastKey-deleteIndex
                this.keyIndexMap.put(lastKey,deleteIndex);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.put(deleteIndex,lastKey);
                this.indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom() {
            if (this.size > 0) {
                int randomIndex = (int) (Math.random() * this.size); //0 ~ size-1
                return this.indexKeyMap.get(randomIndex);
            } else {
                return null;
            }
        }
    }
}
