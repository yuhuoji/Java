package com.leetcode.algorithm.day8;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @date 2023-03-07 15:58
 * <p>
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Leetcode116PopulatingNextRightPointersInEachNode {
    // 层次遍历基于广度优先搜索，它与广度优先搜索的不同之处在于，广度优先搜索每次只会取出一个节点来拓展，而层次遍历会每次将队列中的所有元素都拿出来拓展，
    // 这样能保证每次从队列中拿出来遍历的元素都是属于同一层的，
    // 因此我们可以在遍历的过程中修改每个节点的 next\text{next}next 指针，同时拓展下一层的新队列。
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>(); //
        queue.offer(root);
        while (!queue.isEmpty()) { //遍历层数
            int size = queue.size(); //本层含有的节点数量
            for (int i = 0; i < size; ++i) { //遍历本层节点
                Node node = queue.poll();
                if (i < size - 1) { //连接
                    node.next = queue.peek();
                }
                //下一层节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    //方法二：使用已建立的 next\text{next}next 指针
    public Node connect2(Node root) {
        return root;
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
