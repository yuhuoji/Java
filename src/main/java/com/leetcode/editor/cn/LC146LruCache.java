package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.Map;

// 146 LRU Cache
public class LC146LruCache {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 146);
        int capacity = 10;
        LRUCache cache = new LC146LruCache().new LRUCache(capacity);

    }

    // REVIEW @date 2024-09-20
    // 双向链表+哈希表=哈希链表 LinkedHashMap
    // 哈希表保证O(1) 链表维持时序

    // leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private final int capacity;

        private final Node dummy = new Node();
        private Map<Integer, Node> keyToNode = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dummy.prev = dummy;
            dummy.next = dummy;
        }

        public int get(int key) {
            Node node = getNode(key);
            return node != null ? node.value : -1;
        }

        // 先插入，如果超过容量再删除
        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
                return;
            }
            node = new Node(key, value);
            keyToNode.put(key, node);
            pushFront(node);
            if (keyToNode.size() > capacity) {
                Node backNode = dummy.prev;
                keyToNode.remove(backNode.key);
                removeNode(backNode);
            }
        }

        // 取得节点
        private Node getNode(int key) {
            if (!keyToNode.containsKey(key)) {
                return null;
            }
            Node node = keyToNode.get(key);
            removeNode(node);
            pushFront(node);
            return node;
        }

        // 从链表中删除节点
        private void removeNode(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }

        // 在链表头部添加节点
        private void pushFront(Node x) {
            x.prev = dummy;
            x.next = dummy.next;
            x.prev.next = x;
            x.next.prev = x;
        }

        private static class Node {
            int key, value;
            Node prev, next;

            Node() {
            }

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
// leetcode submit region end(Prohibit modification and deletion)

    class LRUCache1 {
        private int capacity;
        private Map<Integer, DoubleNode> keyNodeMap; // 操作时间O(1)
        private DoubleList nodeList;

        public LRUCache1(int capacity) {
            this.capacity = capacity;
            keyNodeMap = new HashMap<>();
            nodeList = new DoubleList();
        }

        public int get(int key) {
            if (!keyNodeMap.containsKey(key)) {
                return -1;
            }
            DoubleNode ans = keyNodeMap.get(key);
            nodeList.moveNodeToTail(ans);
            return ans.value;
        }

        public void put(int key, int value) {
            if (keyNodeMap.containsKey(key)) { // key存在，是更新操作
                DoubleNode node = keyNodeMap.get(key);
                node.value = value;
                nodeList.moveNodeToTail(node);
            } else { // 添加, 考虑满没满
                if (keyNodeMap.size() == capacity) { // 容量满了，从map和list中都删除
                    keyNodeMap.remove(nodeList.removeHead().key);
                }
                DoubleNode newNode = new DoubleNode(key, value);
                keyNodeMap.put(key, newNode);
                nodeList.addNode(newNode);
            }
        }

        // 双链表的节点
        private class DoubleNode {
            int key, value;
            DoubleNode prev, next;

            DoubleNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 双链表
        // 头表示最不常用的，尾表示最近用的
        private class DoubleList {
            DoubleNode head, tail;

            DoubleList() {
                head = null;
                tail = null;
            }

            // 把新节点添加到尾部
            public void addNode(DoubleNode node) {
                if (node == null) {
                    return;
                }
                if (head == null) { // 链表为空
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
            }

            // 把链表上的节点移动到尾部(最近使用过)
            public void moveNodeToTail(DoubleNode node) {
                if (tail == node) {
                    return;
                }
                if (head == node) { // 是第一个节点
                    head = head.next;
                    head.prev = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                // 放到尾部
                node.prev = tail;
                node.next = null;
                tail.next = node;
                tail = node;
            }

            // 超出容量
            public DoubleNode removeHead() {
                if (head == null) {
                    return null;
                }
                DoubleNode ans = head;
                if (head == tail) { // 只有一个节点
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    ans.next = null;
                    head.prev = null;
                }
                return ans;
            }
        }
    }
}