package com.leetcode.algorithm.day5;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @date 2023-03-04 12:42
 */
public class Leetcode19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd0(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int sz = 0;
        while (fast != null) {
            fast = fast.next;
            ++sz;
        }
        if (sz == n) {
            return head.next;
        }
        sz = sz - n - 1;
        while (sz > 0) {
            slow = slow.next;
            --sz;
        }
        // remove
        slow.next = slow.next.next;
        return head;
    }

    // 方法一：计算链表长度
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); // 添加哑节点（头节点），可以不用对头节点做额外判断
        int length = getLength(head);
        ListNode p = dummy;
        for (int i = 0; i < length - n + 1; ++i) { // 到第length - n个节点
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    ///方法二：栈
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) { // 全部入栈
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) { // n个出栈
            stack.pop();
        }
        ListNode prev = stack.peek(); // 栈顶元素是要删除的前一个节点
        prev.next = prev.next.next;
        return dummy.next;
    }

    // 方法三：双指针
    // fast - slow = n
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n + 1; ++i) {
            fast = fast.next;
        }
        // fast和slow间隔n个节点
        // slow指向待删除的前一个节点，fast指向null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    @Test
    public void test() {

    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
