package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 160 相交链表
public class LC160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "160");
        Solution solution = new LC160IntersectionOfTwoLinkedLists().new Solution();

    }
    // 双指针 两个指针先后走完两个链表，相交的位置停止

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }


        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            ListNode pA = headA, pB = headB;
            boolean flag1 = true, flag2 = true;
            while (pA != pB) {
                if (pA.next == null && flag1) {
                    pA = headB;
                    flag1 = false;
                } else {
                    pA = pA.next;
                }
                if (pB.next == null && flag2) {
                    pB = headA;
                    flag2 = false;
                } else {
                    pB = pB.next;
                }
            }
            return pA;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}