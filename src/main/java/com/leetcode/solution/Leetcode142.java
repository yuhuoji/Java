package com.leetcode.solution;

import org.junit.Test;

/*
 * leetcode142 单链表有环
 *
 * 找到单链表第一个入节点，如果无环返回null */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head, fast = head; //fast -> 2 steps, slow -> 1 step
        while (slow != fast) { //第一次循环
            if (slow.next == null || fast.next == null) { //越界
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head; //fast walk again from head
        while (slow != fast) { //
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    @Test
    public void detectCycleTest() {
        System.out.println("Test");
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        //constructor
        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
