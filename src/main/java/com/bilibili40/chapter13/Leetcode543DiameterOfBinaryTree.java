package com.bilibili40.chapter13;

import com.bilibili40.chapter05.ThreeTraversalAlgorithmsOfBinaryTree;
import org.junit.Test;

/**
 * @date 2023-04-06
 * MaxDistanceInTree
 * 二叉树dp问题的一种分类：root参与和root不参与两种情况
 */
public class Leetcode543DiameterOfBinaryTree {
    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int maxDistance = Math.max(leftInfo.height + 1 + rightInfo.height, Math.max(leftInfo.maxDistance, rightInfo.maxDistance)); //分过node和不过node两种情况
        int height = Math.max(leftInfo.height, rightInfo.height) + 1; //高度
        return new Info(maxDistance, height);
    }

    @Test
    public void test() {

    }

    /**
     * leetcode543
     *
     * @param root 根节点
     * @return The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root).maxDistance - 1;
    }

    private static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
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
