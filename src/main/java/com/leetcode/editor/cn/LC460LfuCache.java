package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.Map;

// 460 LFU Cache
public class LC460LfuCache {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 460);
        int capacity = 10;
        LFUCache cache = new LC460LfuCache().new LFUCache(capacity);

    }

    // REVIEW @date 2023-12-20

    // leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        private final int capacity;
        private final Map<Integer, DoubleNode> keyToNode = new HashMap<>(); // 快速查询
        private final Map<Integer, DoubleNode> freqToDummy = new HashMap<>(); // 快速找到使用频率最小的双向链表
        private int minFreq; // 最小看过次数

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            DoubleNode node = getNode(key);
            return node != null ? node.value : -1; // 没有则返回-1
        }

        public void put(int key, int value) {
            DoubleNode node = getNode(key);
            if (node != null) {
                node.value = value;
                return;
            }
            if (keyToNode.size() == capacity) { // 达到容量，删除使用频率最小的缓存
                DoubleNode dummy = freqToDummy.get(minFreq); // 找到使用频率最小的
                DoubleNode backNode = dummy.prev; // 找到使用频率最小的中最后一次使用的缓存
                keyToNode.remove(backNode.key);
                removeNode(backNode);
                if (dummy.prev == dummy) { // 删除后为空链表
                    freqToDummy.remove(minFreq);
                }
            }
            // 添加新节点
            node = new DoubleNode(key, value);
            keyToNode.put(key, node);
            pushFront(1, node); // 开始频率为1
            minFreq = 1; // 添加新节点后最小频率更新为1
        }

        // 返回节点，没有则返回null。移动到头部
        private DoubleNode getNode(int key) {
            if (!keyToNode.containsKey(key)) {
                return null;
            }
            DoubleNode node = keyToNode.get(key); // 有对应的缓存
            removeNode(node); // 先删除
            DoubleNode dummy = freqToDummy.get(node.freq);
            if (dummy.prev == dummy) { // 没有最后一个节点，该链表为空
                freqToDummy.remove(node.freq); // 移除空链表
                if (minFreq == node.freq) {
                    minFreq++;
                }
            }
            pushFront(++node.freq, node);
            return node;
        }

        // 创建新的双向链表
        private DoubleNode newList() {
            DoubleNode dummy = new DoubleNode(0, 0);
            dummy.next = dummy;
            dummy.prev = dummy;
            return dummy;
        }

        // 在链表头插新节点
        private void pushFront(int freq, DoubleNode node) {
            DoubleNode dummy = freqToDummy.computeIfAbsent(freq, k -> newList()); // 如果链表为空则创建新链表
            node.prev = dummy;
            node.next = dummy.next;
            node.prev.next = node;
            node.next.prev = node;
        }

        // 删除一个节点
        private void removeNode(DoubleNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // 双向链表节点
        private class DoubleNode {
            int key, value;
            int freq = 1; // 最开始都使用了一次
            DoubleNode prev, next;

            DoubleNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// leetcode submit region end(Prohibit modification and deletion)

}