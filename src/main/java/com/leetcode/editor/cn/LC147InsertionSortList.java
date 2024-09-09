package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 147 对链表进行插入排序
public class LC147InsertionSortList {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "147");
        Solution solution = new LC147InsertionSortList().new Solution();

    }
    // 头插法 插入排序 维护一个有序列表 O(N^2)

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
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode cur = head.next;
            ListNode last = head;
            while (cur != null) {
                if (cur.val >= last.val) {
                    last = last.next;
                } else {
                    ListNode pre = dummy;
                    while (pre.next.val < cur.val) { //< 找到第一个大于等于cur的节点；<= 找到第一个大于cur的节点
                        pre = pre.next;
                    }
                    last.next = cur.next;
                    cur.next = pre.next;
                    pre.next = cur;
                }
                cur = last.next;
            }
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}