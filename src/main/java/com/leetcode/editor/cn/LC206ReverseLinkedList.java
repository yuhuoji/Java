package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 206 反转链表
public class LC206ReverseLinkedList {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 206);
        Solution solution = new LC206ReverseLinkedList().new Solution();

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
        // 递归 三部分 1.递归结束条件 2.进行的递归操作 3.返回值
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = reverseList(head.next);

            head.next.next = head;
            head.next = null;
            return newHead;
        }

        // 迭代
        public ListNode reverseList1(ListNode head) {
            ListNode pre = null, cur = head, nxt;
            while (cur != null) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            return pre;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}