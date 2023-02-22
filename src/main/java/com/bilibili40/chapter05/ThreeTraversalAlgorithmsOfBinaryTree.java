package com.bilibili40.chapter05;

import java.util.Stack;

/**
 * 二叉树
 * ！！！递归序！！！
 * 三种遍历算法
 * stack first in last out !!!
 */
public class ThreeTraversalAlgorithmsOfBinaryTree {
    /* 递归序 */
    public void orderOfRecursion(Node head) {
        if (head == null) {
            return;
        }
        orderOfRecursion(head.left);
        orderOfRecursion(head.right);
    }

    /* 先序遍历非递归 */
    public void preorderTraversalNonRecursive(Node head) {
        System.out.println("pre order");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop(); //head.left
                System.out.print(head.value + " ");
                /* 先右后左 */
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    /* 后序遍历非递归
     * 两个栈 头左右 -> stack1 -> 头右左 -> stack2 -> 左右头  */
    public void postOrderTraversalNonRecursive(Node head) {
        System.out.println("post order");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head); //stack1 -> 头右左 ->stack2
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            //打印stack2
            while (!stack2.isEmpty()) {
                System.out.print((stack2.pop().value + " "));
            }
        }
        System.out.println();
    }

    /* 中序遍历非递归
     *  头左右 -> stack1 ->  左头右 */
    public void inOrderTraversalNonRecursive(Node head) {
        System.out.println("in order");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) { //
                if (head != null) { //检查left or right
                    stack.push(head);
                    head = head.left; //检查左子树
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right; //检查右子树
                }
            }
        }
        System.out.println();
    }

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
