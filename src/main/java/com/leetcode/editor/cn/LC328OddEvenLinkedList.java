package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 328 奇偶链表
public class LC328OddEvenLinkedList {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 328);
        Solution solution = new LC328OddEvenLinkedList().new Solution();

    }
    // 按奇偶分成两个链表，然后odd.next = even
    // 时间O(N)， 空间O(1)
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
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode odd = head;
            ListNode even = head.next, evenHead = odd.next;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}