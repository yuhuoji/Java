package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 23 Merge k Sorted Lists
public class LC23MergeKSortedLists {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 23);
        Solution solution = new LC23MergeKSortedLists().new Solution();
        ListNode node = solution.merge(null, new ListNode(0));
        System.out.println(node);
    }
    // 两两合并
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
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            if (n == 0) { //[]
                return null;
            }
            return mergeKLists(lists, 0, n - 1);
        }

        //[l, r]
        public ListNode mergeKLists(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = ((r - l) >> 1) + l;
            //[l,mid] [mid+1,r]
            return merge(mergeKLists(lists, l, mid), mergeKLists(lists, mid + 1, r));
        }

        private ListNode merge(ListNode p1, ListNode p2) {
            ListNode dummy = new ListNode(0);
            ListNode pre = dummy;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    pre.next = p1;
                    p1 = p1.next;
                } else {
                    pre.next = p2;
                    p2 = p2.next;
                }
                pre = pre.next;
            }
            pre.next = p1 == null ? p2 : p1;
            return dummy.next;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            if (n == 0) { //[]
                return null;
            }
            ListNode dummy = new ListNode(0, lists[0]);
            for (int i = 1; i < n; ++i) { // 合并i-1 和 i
                dummy.next = merge(dummy.next, lists[i]);
            }
            return dummy.next;
        }

        //合并两个有序链表，可能为null
        private ListNode merge(ListNode p1, ListNode p2) {
            ListNode dummy = new ListNode(0);
            ListNode pre = dummy;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    pre.next = p1;
                    p1 = p1.next;
                } else {
                    pre.next = p2;
                    p2 = p2.next;
                }
                pre = pre.next;
            }
            pre.next = p1 == null ? p2 : p1;
            return dummy.next;
        }
    }
}