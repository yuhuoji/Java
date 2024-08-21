package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 19 删除链表的倒数第 N 个结点
public class LC19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "19");
        Solution solution = new LC19RemoveNthNodeFromEndOfList().new Solution();

    }
    // 双指针

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre, p = dummy;
            for (int i = 0; i < n; ++i) {
                p = p.next;
            }
            pre = dummy;
            while (p.next != null) {
                pre = pre.next;
                p = p.next;
            }
            pre.next = pre.next.next;
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}