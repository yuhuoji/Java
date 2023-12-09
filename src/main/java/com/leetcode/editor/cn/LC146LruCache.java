package com.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// 146 LRU Cache
public class LC146LruCache {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 146);
        int capacity = 10;
        LRUCache cache = new LC146LruCache().new LRUCache(capacity);

    }

    // 双向链表+哈希表=哈希链表 LinkedHashMap
    // leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        int capacity;
        Map<Integer, DoubleNode> keyNodeMap; // 操作时间O(1)
        DoubleList nodeList;

        public LRUCache(int capacity) {
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
        class DoubleNode {
            int key;
            int value;
            DoubleNode prev, next;

            DoubleNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 双链表
        // 头表示最不常用的，尾表示最近用的
        class DoubleList {
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// leetcode submit region end(Prohibit modification and deletion)

}