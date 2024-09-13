package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 234 回文链表
public class LC234PalindromeLinkedList {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "234");
        Solution solution = new LC234PalindromeLinkedList().new Solution();

    }
    // 快慢指针找到第一段的结尾，结合lc206反转链表
    // 长度可能奇数或偶数

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
        public boolean isPalindrome(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode p1 = dummy, p2 = dummy;
            while (p2 != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            }
            ListNode firstTail = p1, secondHead = p1.next;
            firstTail.next = null;
            secondHead = reverseList(secondHead); // 翻转第二段
            p1 = head;
            p2 = secondHead;
            while (p1 != null && p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            // 恢复
            secondHead = reverseList(secondHead);
            firstTail.next = secondHead;
            return true;
        }

        private ListNode reverseList(ListNode head) {
            ListNode pre = null, cur = head, nxt = null;
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