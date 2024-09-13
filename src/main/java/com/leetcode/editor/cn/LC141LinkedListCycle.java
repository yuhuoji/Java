package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 141 环形链表
public class LC141LinkedListCycle {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "141");
        Solution solution = new LC141LinkedListCycle().new Solution();

    }
    // REVIEW @date 2024-08-16

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (true) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    break;
                }
            }
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast != null;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}