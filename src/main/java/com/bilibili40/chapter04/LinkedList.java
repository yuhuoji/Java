package com.bilibili40.chapter04;

import org.junit.Test;

/**
 * TODO 链表
 * 单链表，双向链表
 */
public class LinkedList {

    private ListNode head; //链表的头节点

    public ListNode createLinkedList() {

        System.out.println("createLinkedList");

        this.head = new ListNode(00);
        ListNode listNode1 = new ListNode(11);
        ListNode listNode2 = new ListNode(22);
        ListNode listNode3 = new ListNode(33);
        ListNode listNode4 = new ListNode(44);
        ListNode listNode5 = new ListNode(55);

        this.head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return this.head;
    }

    /* 打印链表 */
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null\n");
    }

    //头插法
    public void addFirst(int data) {
    }

    //尾插法
    public void addLast(int data) {
    }

    //清空链表
    public void clear() {
    }

    /**
     * leetcode 206 翻转链表
     * Definition for singly-linked list.
     * public class ListNode {
     *      int val;
     *      ListNode next;
     *      ListNode() {}
     *      ListNode(int val) { this.val = val; }
     *      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     * 方法一：迭代
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)。
     * @param head 首节点
     * @return newHead
     */
    public ListNode reverseListIteration(ListNode head) { //迭代 时间O（N） 空间O（1）
        if (head == null || head.next == null) { //空链表或只有一个节点
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next; //保存下一个节点 pre -> cur -> next
            cur.next = pre; //pre <- cur -> next
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 方法二：递归
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
     * 空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
     * @param head 首节点
     * @return newHead
     * 原链表1 -> 2 -> ...  -> k-1 -> k -> k+1 -> ... -> n -> null
     * 现在1 -> 2 -> ...  -> k-1 -> k -> k+1 <- ... <- n
     * pre = k-1, cur = k, 如何翻转之前的部分？ cur.next.next = cur, cur.next = null, 返回首节点
     */
    public ListNode reverseList1(ListNode head) { //递归 时间O（N） 空间O（N）
        if (head == null || head.next == null) { //获取最后一个节点
            return head;
        }
        /* 1 -> 2 -> 3 -> 4 -> 5 -> null
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1 -> 2 -> 3 -> 4 <-> 5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1 -> 2 -> 3 -> 4 <- 5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1 -> 2 -> 3 <-> 4 <- 5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1 -> 2 -> 3 <-4 <- 5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1 -> 2 <-> 3 <- 4 <- 5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1 -> 2 <- 3 <- 4 <- 5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1 <-> 2 <- 3 <- 4 <- 5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1 <-2 <- 3 <- 4 <- 5
                      返回节点5
            出栈完成，最终头节点5 -> 4 -> 3 -> 2 -> 1
         */
        ListNode newHead = reverseList1(head.next); //获得新头,它被定义为递的终点处的head节点，然后在归的过程传递回来，顺便将链表反转。
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    @Test
    public void test() {
        System.out.println("test");
        this.createLinkedList();
        this.display();
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
