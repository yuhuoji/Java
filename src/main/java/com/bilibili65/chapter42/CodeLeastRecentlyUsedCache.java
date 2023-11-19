package com.bilibili65.chapter42;

import org.junit.Test;

import java.util.HashMap;

/**
 * @date 2023-02-26 17:46
 * LRU
 */
public class CodeLeastRecentlyUsedCache {
    @Test
    public void test() {
        MyCache<String, Integer> testCache = new MyCache<>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.set("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C")); //使用最少的
    }

    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> last; //前一个
        public Node<K, V> next; //后一个

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //双向链表
    public static class NodeDoubleLinkedList<K, V> {
        private Node<K, V> head; //头指针
        private Node<K, V> tail; //尾指针

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        //增加新节点，加到链尾
        public void addNode(Node<K, V> newNode) {
            if (newNode == null) { //base case
                return;
            }
            //newNode!=null
            if (this.head == null) { //只有一个节点
                this.head = newNode;
                this.tail = newNode;
            } else { //原来右节点
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }

        //原来存在Node，移除并放到链尾
        public void moveNodeToTail(Node<K, V> node) {
            if (this.tail == node) { //只有一个节点
                return;
            }
            if (this.head == node) { //node是第一个节点
                this.head = node.next;
                this.head.last = null;
            } else { //node是中间节点
                node.last.next = node.next;
                node.next.last = node.last;
            }
            //分离node后连接至链尾
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        //删除头节点并返回
        public Node<K, V> removeHead() {
            if (this.head == null) { //空链表
                return null;
            }
            Node<K, V> res = this.head;
            if (this.head == this.tail) { //只有一个节点
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                this.head.last = null;
                res.next = null;
            }
            return res;
        }

    }

    //LRU
    public static class MyCache<K, V> {
        private final int capacity; //黑盒容量
        private HashMap<K, Node<K, V>> keyNodeMap; //哈希表，key - 内存地址
        private NodeDoubleLinkedList<K, V> nodeList; //双链表，保证黑盒内节点的相对次序

        public MyCache(int capacity) {
            this.keyNodeMap = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList();
            this.capacity = capacity;
        }

        //根据key返回value
        public V get(K key) {
            if (this.keyNodeMap.containsKey(key)) {
                Node<K, V> res = this.keyNodeMap.get(key); //内存地址
                this.nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        //新增或更新
        public void set(K key, V value) {
            if (this.keyNodeMap.containsKey(key)) { //原来存在，更新value
                Node<K, V> node = this.keyNodeMap.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node); //将更新值的节点移动到链尾
            } else { //原来不存在，新增一个节点;可能容量超出需要删除使用最少的节点
                Node<K, V> newNode = new Node<>(key, value);
                this.keyNodeMap.put(key, newNode);
                this.nodeList.addNode(newNode);
                if (this.keyNodeMap.size() == this.capacity + 1) { //超出容量，需要删除一个节点
                    this.removeMostUnusedCache();
                }
            }
        }

        //删除头节点（使用最少的节点）
        private void removeMostUnusedCache() {
            Node<K, V> removeNode = this.nodeList.removeHead(); //从双链表中删除
            this.keyNodeMap.remove(removeNode.key); //从hashmap删除
        }
    }
}
