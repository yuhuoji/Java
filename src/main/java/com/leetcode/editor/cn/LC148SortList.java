package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 148 Sort List
public class LC148SortList {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 148);
        Solution solution = new LC148SortList().new Solution();
        String s = "[4,2,1,3]";
        System.out.println(solution.sortList(LeetCodeHelper.stringToListNode(s)));
    }
    //TODO @date 2024-08-21

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
        // 迭代
        // 自底向上
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0, head);
            int len = 0; // 链表长度
            ListNode node = head;
            while (node != null) {
                node = node.next;
                len++;
            }

            for (int subLen = 1; subLen < len; subLen <<= 1) { // 拆分链表合并 1 2 4...
                ListNode pre = dummy; // pre 用于连接合并后排序好的链表，相当于记录结果
                ListNode cur = dummy.next;
                while (cur != null) {
                    ListNode head1 = cur; // 第一段
                    for (int i = 0; i < subLen - 1 && cur != null && cur.next != null; ++i) {
                        cur = cur.next;
                    }

                    ListNode head2 = cur.next;// 第二段
                    cur.next = null; // 断开第一段结尾
                    cur = head2;
                    for (int i = 0; i < subLen - 1 && cur != null && cur.next != null; ++i) {
                        cur = cur.next;
                    }

                    ListNode nxt = null;
                    if (cur != null) { // 还有没分完的
                        nxt = cur.next;
                        cur.next = null; // 断开第二段结尾
                    }
                    ListNode merged = merge(head1, head2);

                    pre.next = merged;
                    while (pre.next != null) {
                        pre = pre.next;
                    }
                    cur = nxt;
                }
            }
            // subLen = len 归并结束
            return dummy.next;
        }

        // 合并有序链表
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

    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0, head);
            ListNode fast = head, slow = dummy;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode secondHead = slow.next;
            slow.next = null;
            head = sortList(head);
            secondHead = sortList(secondHead);
            ListNode pre = dummy, p1 = head, p2 = secondHead;
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
            pre.next = p2 == null ? p1 : p2;
            return dummy.next;
        }


        // 递归
        public ListNode sortList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0, head);
            ListNode slow = dummy, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow.next; // 中点
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            return merge(left, right);
        }

        // 合并有序链表
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

}