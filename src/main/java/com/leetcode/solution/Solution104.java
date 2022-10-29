package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;
/**
 *  leetcode104
 * 二叉树的最大深度
 * DATE 2022/10/6 14:24
 */
public class Solution104 {
    /* DFS 深度优先 recursion */
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthDFS(root.left); //递归
        int rightDepth = maxDepthDFS(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /* BFS 广度优先搜索 */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0; //二叉树的深度
        while (!queue.isEmpty()) {
            int size = queue.size(); //当前层节点个数
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if ((node.right != null)) {
                    queue.offer(node.right);
                }
            }
            depth++; //当前层的节点全部出队
        }
        return depth;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
