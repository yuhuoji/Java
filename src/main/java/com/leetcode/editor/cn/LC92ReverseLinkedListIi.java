package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 92 Reverse Linked List II
public class LC92ReverseLinkedListIi {
    public static void main(String[] args) {
        System.out.println("LC " + 92);
        Solution solution = new LC92ReverseLinkedListIi().new Solution();

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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode p0 = dummy;
            for (int i = 0; i < left - 1; ++i) { // 获取节点个数
                p0 = p0.next; // left-1
            }

            ListNode pre = null, cur = p0.next, nxt;
            for (int i = 0; i < right - left + 1; ++i) { // 反转
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }

            // p0 left.. right(pre) cur

            p0.next.next = cur;
            p0.next = pre;

            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}