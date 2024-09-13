package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.List;

// 25 Reverse Nodes in k-Group
public class LC25ReverseNodesInKGroup {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 25);
        Solution solution = new LC25ReverseNodesInKGroup().new Solution();

    }

    // TODO @date 2024-08-19

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
        // 迭代 先统计个数，然后k个一组翻转
        public ListNode reverseKGroup(ListNode head, int k) {
            int n = 0; // 链表长度
            for (ListNode cur = head; cur != null; cur = cur.next) {
                n++;
            }
            ListNode dummy = new ListNode(0, head);
            ListNode p0 = dummy; // 每一段第一个节点的上一个节点
            ListNode pre = null, cur = head, nxt;
            for (; n >= k; n -= k) {
                for (int i = 0; i < k; ++i) {
                    nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                }
                // pre是结尾 cur是下一段的开头 用nxt保存下一段开头的上一个节点
                nxt = p0.next;
                p0.next.next = cur;
                p0.next = pre;
                p0 = nxt;
            }
            return dummy.next;
        }

        // 迭代 先找k个节点，然后翻转
        public ListNode reverseKGroup2(ListNode head, int k) {
            ListNode dummy = new ListNode(0, head);
            ListNode cur = head; // 当前节点
            ListNode start = dummy; // 起点的前一个节点
            outerLoop:
            while (true) {
                /// start = cur; // 本组起点前一个节点
                // 先遍历k个节点，如果不够k个节点就结束
                for (int i = 0; i < k; ++i) {
                    if (cur == null) {
                        break outerLoop;
                    }
                    cur = cur.next;
                }
                ListNode end = start.next; // 翻转后的结尾
                // 翻转k个节点
                ListNode pre = null, nxt;
                cur = start.next;
                for (int i = 0; i < k; ++i) {
                    nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                }
                // 前后连接
                // pre是最后一个节点
                start.next = pre;
                end.next = cur;
                start = end;
            }
            return dummy.next;
        }

        // 递归
        public ListNode reverseKGroup1(ListNode head, int k) {
            // 不足k个
            ListNode cur = head;
            for (int i = 0; i < k; ++i) {
                if (cur == null) {
                    return head;
                }
                cur = cur.next;
            }
            ListNode tail = head;
            // 翻转前k个
            ListNode pre = null, nxt = null;
            cur = head;
            for (int i = 0; i < k; ++i) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            tail.next = reverseKGroup(nxt, k); // 继续翻转剩下链表，连接
            return pre;
        }

        // 迭代
        public ListNode reverseKGroup0(ListNode head, int k) {
            ListNode dummy = new ListNode(0, head);
            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }

            ListNode p0 = dummy;

            while (len >= k) {
                len -= k;
                // k个一组翻转
                ListNode pre = null, cur = p0.next, nxt = null;
                for (int i = 0; i < k; ++i) {
                    nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                }
                // p0 pre是新的首节点 cur是下一段的开头
                nxt = p0.next;
                nxt.next = cur;
                p0.next = pre;
                p0 = nxt;
            }
            return dummy.next;
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

}