package com.arithmeticBiliBili.chapter06;

import com.arithmeticBiliBili.chapter05.TreeMaxWidth;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 2022-10-29 15:59
 * 完全二叉树
 */

public class CompleteBinaryTree {
    //判断是否为完全二叉树，层次遍历
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

    @Test
    public void completeBinaryTreeTest() {

    }

    private static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }
}
