package com.arithmeticBiliBili.chapter06;

import org.junit.Test;

/**
 * 平衡二叉搜索树
 * BF（balanced factor）,平衡因子 = 0（等高），1（左子树高），-1（右子树高）
 *
 * @date 2022-10-29 16:44
 */
public class BalancedBinaryTree {
    /* FIXME 判断是否为平衡二叉树(1.是搜索二叉树 2.左右子树高度相差不超过1)，递归 */
    public boolean isAVL(TreeNode head) {
        int flag = isAVLProcess(head); //不是平衡二叉树返回-1，否则返回该平衡二叉树的高度
        if (flag == -1) {
            return false;
        } else {
            return true;
        }
    }

    private int isAVLProcess(TreeNode head) {
        //为高度返回0
        if (head == null) {
            return 0;
        }
        int left = isAVLProcess(head.left);
        int right = isAVLProcess(head.right);
        if (left != -1 && right != -1 && Math.abs(left - right) <= 1) { //都是完全二叉树
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }

    /* leetcode 110 判断搜索二叉树 自定向下
     * 平衡二叉树 = 左子树是AVL + 右子树是AVL + 左右子树高度相差不超过1
     * */
    //先序遍历
    public boolean isBalancedTopToBottom(TreeNode head) {
        if (head == null) {
            return true;
        } else {
            return Math.abs(heightTopToBottom(head.left) - heightTopToBottom(head.right)) <= 1 && isBalancedTopToBottom(head.left) && isBalancedTopToBottom(head.right);
        }
    }

    private int heightTopToBottom(TreeNode head) {
        if (head == null) {
            return 0;
        } else {
            return Math.max(heightTopToBottom(head.left), heightTopToBottom(head.right)) + 1; //递归求高度
        }
    }

    //后序遍历
    public boolean isBalancedBottomToTop(TreeNode head) {
        return heightBottomToTop(head) >= 0;
    }

    private int heightBottomToTop(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftHeight = heightBottomToTop(head.left);
        int rightHeight = heightBottomToTop(head.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    @Test
    public void balancedBinaryTreeTest() {
        System.out.println("test");
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
