package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 21 合并两个有序链表
public class LC21MergeTwoSortedLists {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "21");
        Solution solution = new LC21MergeTwoSortedLists().new Solution();

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode pre = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    pre.next = list1;
                    list1 = list1.next;
                    pre = pre.next;
                } else {
                    pre.next = list2;
                    list2 = list2.next;
                    pre = pre.next;
                }
            }
            pre.next = list1 == null ? list2 : list1;
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}