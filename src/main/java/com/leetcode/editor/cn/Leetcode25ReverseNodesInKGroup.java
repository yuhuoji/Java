package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.List;

// 25 Reverse Nodes in k-Group
public class Leetcode25ReverseNodesInKGroup {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 25);
        Solution solution = new Leetcode25ReverseNodesInKGroup().new Solution();

    }
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
        // 迭代
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0, head);
            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }

            ListNode p0 = dummy;

            while (len >= k) {
                len -= k;
                // k个一组翻转
                ListNode pre = null, cur = p0.next, nxt = null;
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


        // 递归
        public ListNode reverseKGroup1(ListNode head, int k) {
            // base case, 不足k个
            ListNode node = head;
            for (int i = 0; i < k; ++i) {
                if (node == null) {
                    return head;
                }
                node = node.next;
            }
            // k个一组反转
            ListNode tail = new ListNode(-1, head);
            ListNode pre = tail, cur = head, nxt;
            for (int i = 0; i < k; ++i) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            tail.next.next = reverseKGroup(cur, k);  // 返回头节点
            return pre;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}