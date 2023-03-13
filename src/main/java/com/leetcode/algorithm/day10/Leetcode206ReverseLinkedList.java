package com.leetcode.algorithm.day10;

/**
 * @date 2023-03-13 16:14
 */
public class Leetcode206ReverseLinkedList {

    //1->2->3->4->5->null
    //null<-1<-2<-3<-4<-5
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) { //空或只有一个节点
            return head;
        }
        ListNode prev = null;
        ListNode curr = head; //当前操作的节点
        ListNode next;
        // prev  curr -> next
        // prev <- curr  next
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //TODO 方法二：递归
    //1->2->curr->4->5->null
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //1->2->curr->4->5->null
        ListNode newHead = reverseList2(head.next); //黑盒
        //1->2->curr->4<-5

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // Definition for singly-linked list.
    public class ListNode {
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
