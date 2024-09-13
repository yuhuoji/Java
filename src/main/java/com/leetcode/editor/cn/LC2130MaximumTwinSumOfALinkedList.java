package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// 2130 链表最大孪生和
public class LC2130MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2130);
        Solution solution = new LC2130MaximumTwinSumOfALinkedList().new Solution();

    }
    // 孪生 i + (n-1-i) = n-1
    // 1.栈
    // 2.双指针 反转链表
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
        public int pairSum(ListNode head) {
            ListNode slow = head, fast = head.next;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode firstEnd = slow, secondHead = slow.next;
            firstEnd.next = null;
            secondHead = reverseList(secondHead);
            ListNode p1 = head, p2 = secondHead;
            int mx = 0;
            while (p1 != null) {
                mx = Math.max(mx, p1.val + p2.val);
                p1 = p1.next;
                p2 = p2.next;
            }
            firstEnd.next = reverseList(secondHead); // 恢复链表
            return mx;
        }

        private ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = reverseList(head.next);

            head.next.next = head;
            head.next = null;
            return newHead;
        }

        // 双端队列
        public int pairSum1(ListNode head) {
            int mx = 0;
            Deque<Integer> st = new ArrayDeque<>(); // index, value
            int cnt = 0;
            ListNode cur = head;
            while (cur != null) {
                st.add(cur.val);
                cnt++;
                cur = cur.next;
            }
            for (int i = 0; i < cnt / 2; ++i) {
                int x = st.pollFirst(), y = st.pollLast();
                mx = Math.max(mx, x + y);
            }
            return mx;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}