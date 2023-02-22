package com.bilibili40.chapter06;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 2022-10-29 15:59
 * 完全二叉树
 */
public class CompleteBinaryTree {
    //判断是否为完全二叉树，层次遍历，非递归
    public boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (
                    (leaf && (cur.left != null || cur.right != null)) //遍历到最后一个非叶节点后，又出现一个非叶节点
                            ||
                            (cur.left == null && cur.right != null) //无左节点，有右节点
            ) {
                return false;
            }

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            //最后一个非叶节点,没有字节点或只有左节点
            if (cur.left == null || cur.right == null) {
                leaf = true;
            }

        }
        return true;
    }

    //判断是否为完全二叉树（满二叉树），递归
    public boolean isBST2(TreeNode head) {
        if (head == null) {
            return true;
        }
        Result headResult = process2(head);
        return headResult.nodesNum == ((1 << headResult.height) - 1);
    }

    private Result process2(TreeNode head) {
        if (head == null) {
            return new Result(0, 0);
        }
        Result leftResult = process2(head.left);
        Result rightResult = process2(head.right);
        //整个树的高度是两个子树高的度最大值+1，节点个数是left+right+1
        int height = Math.max(leftResult.height, rightResult.height);
        int nodesNum = leftResult.nodesNum + rightResult.nodesNum;
        return new Result(height, nodesNum);
    }

    private static class Result {
        int height; //树的高度
        int nodesNum; //树的节点数目

        Result(int height, int nodesNum) {
            this.height = height;
            this.nodesNum = nodesNum;
        }
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}

class CompleteBinaryTreeTest {
    @Test
    public void completeBinaryTreeTest() {
        System.out.println("test");
    }
}

