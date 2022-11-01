package com.bilibili.chapter05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DATE 2022/10/6 14:34
 * 二叉树每层节点数的最大值
 */
public class TreeMaxWidth {
    //层次遍历
    public void levelOrderTraversal(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
