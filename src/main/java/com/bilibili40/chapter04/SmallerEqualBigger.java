package com.bilibili40.chapter04;

import org.junit.jupiter.api.Test;

/* 单链表分成小于，等于，大于部分； 原顺序不变 */

public class SmallerEqualBigger {

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

    public ListNode isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sH = null; //small head
        ListNode sT = null; //small tail
        ListNode eH = null; //equal head
        ListNode eT = null; //equal tail
        ListNode bH = null; //big head
        ListNode bT = null; //big tail
        ListNode next = null;
        /* TODO partition 。。。。。。。 */

        /* TODO reconnection of three parts: sH -> sT -> eH -> eT -> bH -> bT -> null */
        /* TODO 多段链表相连，每段都可能为空，只遍历一遍，保证头尾不变 */
        ListNode pre = null; //保存上一个不为空的链表的尾

        if (null != sH) { //small part
            sT.next = eH;
            pre = sT;
        } else {
            sH = eH;
        } //head = sH , tail = eT

        if (null != eH) { //equal part
            eT.next = bH;
            pre = eT;
        } else {
            if (null != pre) {
                pre.next = bH;
            }else {
                sT = bH;
            }
        }

        /*
        sH = sH != null ? sH : (eH != null ? eH : bH); //head
        bT = bT != null ? bT : (eT != null ? eT : sT); //tail
        */
        /* head = sH , tail = bT */
        return sH;
    }

    @Test
    public void smallerEqualBiggerTest() {

    }
}
