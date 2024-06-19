package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.List;

// 2095 删除链表的中间节点
public class LC2095DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2095);
        Solution solution = new LC2095DeleteTheMiddleNodeOfALinkedList().new Solution();

    }
    // 1. 计数
    // 2. 快慢指针 指出⌊x⌋的上一个节点，即⌊x⌋-1
    // 用dummy避免只有一个节点的情况
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
        public ListNode deleteMiddle(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode s = dummy, f = head;
            while (f != null && f.next != null) {
                s = s.next;
                f = f.next.next;
            }
            s.next = s.next.next;
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}