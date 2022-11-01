package com.bilibili.chapter04;

import org.junit.Test;

/* 链表
 * 单链表，双向链表
 * */
/* 节点 */


public class LinkedList {

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
     * leetcode 206
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode reverseList(ListNode head) { //迭代 时间O（N） 空间O（1）
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next; //保存下一个节点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     *
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
        /*
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1->2->3->4<-5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1->2->3<-4<-5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1->2<-3<-4<-5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1<-2<-3<-4<-5
                      返回节点5
            出栈完成，最终头节点5->4->3->2->1
         */
        ListNode newHead = reverseList1(head.next); //获得新头
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
}
