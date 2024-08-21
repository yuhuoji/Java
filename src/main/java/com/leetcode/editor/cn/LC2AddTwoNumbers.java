package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2 两数相加
public class LC2AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "2");
        Solution solution = new LC2AddTwoNumbers().new Solution();

    }
    // l2加到l1上
    // 进位

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

        // l2加到l1上
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0, l1);
            ListNode p1 = l1, p2 = l2, pre = dummy;
            int sum = 0, carry = 0;
            while (p1 != null || p2 != null) {
                if (p1 == null) { // 交换p1 p2
                    pre.next = p2;
                    p1 = p2;
                    p2 = null;
                }
                int num1 = p1 != null ? p1.val : 0;
                int num2 = p2 != null ? p2.val : 0;
                sum = num1 + num2 + carry;
                p1.val = sum % 10;
                carry = sum / 10;
                pre = pre.next;
                if (p1 != null) {
                    p1 = p1.next;
                }
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
            if (carry > 0) {
                pre.next = new ListNode(carry, null);
            }
            return dummy.next;
        }

        // 创建新链表
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0, null);
            ListNode p1 = l1, p2 = l2, pre = dummy;
            int sum = 0, carry = 0;
            while (p1 != null || p2 != null || carry > 0) {
                int num1 = p1 != null ? p1.val : 0;
                int num2 = p2 != null ? p2.val : 0;
                sum = num1 + num2 + carry;
                pre.next = new ListNode(sum % 10, null);
                carry = sum / 10;
                pre = pre.next;
                if (p1 != null) {
                    p1 = p1.next;
                }
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}