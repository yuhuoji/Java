package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 24 Swap Nodes in Pairs
public class LC24SwapNodesInPairs {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 24);
        Solution solution = new LC24SwapNodesInPairs().new Solution();

    }
    // lc25 k个一组翻转链表

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode swapPairs2(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode p0 = dummy, node1 = head;
            while (node1 != null && node1.next != null) {
                ListNode node2 = node1.next;
                ListNode nxt = node2.next;
                node2.next = node1;
                p0.next = node2;
                node1.next = nxt;
                // 下一轮 p0是上一个节点， node1是第一个节点
                p0 = node1;
                node1 = nxt;
            }
            return dummy.next;
        }

        // k个一组反转链表
        public ListNode swapPairs1(ListNode head) {
            // 拿到长度
            ListNode dummy = new ListNode(0, head);
            ListNode cur = head;
            int len = 0;
            while (cur != null) {
                cur = cur.next;
                len++;
            }

            ListNode p0 = dummy; // 本段的上一个节点
            ListNode pre = null, nxt;
            while (len >= 2) {
                len -= 2;
                cur = p0.next;
                for (int i = 0; i < 2; ++i) { // 两个一组反转链表
                    nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                }
                nxt = p0.next;
                p0.next = pre;
                nxt.next = cur;
                p0 = nxt;
            }

            return dummy.next;
        }

        public ListNode swapPairs(ListNode head) {
            int n = 0;
            for (ListNode cur = head; cur != null; cur = cur.next) {
                n++;
            }
            ListNode dummy = new ListNode(0, head);
            ListNode p0 = dummy;
            ListNode pre = null, cur = head, nxt;
            int k = 2;
            for (; n >= k; n -= k) {
                for (int i = 0; i < k; ++i) {
                    nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                }
                nxt = p0.next;
                p0.next.next = cur;
                p0.next = pre;
                p0 = nxt;
            }
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}