package com.leetcode.algorithm.day10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @date 2023-03-13 11:05
 * 递归 / 回溯
 */
public class Leetcode21MergeTwoSortedLists {
    // 方法一：递归
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            return mergeTwoLists1(list1.next, list2);
        } else {
            return mergeTwoLists1(list1, list2.next);
        }
    }

    //
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pre.next = p1;
                p1 = p1.next;
            } else { // p1.val > p2.val
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }
        // 一个被合并完，一个没合并完
        pre.next = p1 == null ? p2 : p1;
        // 返回合并后的头节点
        return head.next;
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
