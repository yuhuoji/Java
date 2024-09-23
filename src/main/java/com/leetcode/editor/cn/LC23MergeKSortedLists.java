package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Comparator;
import java.util.PriorityQueue;

// 23 Merge k Sorted Lists
public class LC23MergeKSortedLists {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 23);
        Solution solution = new LC23MergeKSortedLists().new Solution();

    }
    // REVIEW @date 2024-09-15 最小堆

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
    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
            for (ListNode head : lists) {
                if (head != null) {
                    pq.offer(head);
                }
            }
            ListNode dummy = new ListNode();
            ListNode pre = dummy;
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                if (node.next != null) {
                    pq.offer(node.next);
                }
                pre.next = node;
                pre = pre.next;
            }
            return dummy.next;
        }
    }

    // 分治，归并
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            if (n == 0) { //[]
                return null;
            }
            return mergeKLists(lists, 0, n - 1);
        }

        // 分治，归并
        public ListNode mergeKLists(ListNode[] lists, int l, int r) {
            if (l > r) {
                return null;
            }
            if (l == r) {
                return lists[l];
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

        private ListNode merge(ListNode p1, ListNode p2) {
            ListNode dummy = new ListNode();
            ListNode pre = dummy;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    pre.next = p1;
                    p1 = p1.next;
                } else {
                    pre.next = p2;
                    p2 = p2.next;
                }
                pre = pre.next;
            }
            pre.next = p1 != null ? p1 : p2;
            return dummy.next;
        }
    }
}