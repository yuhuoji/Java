package com.bilibili.chapter06;

import org.junit.Test;

/**
 * @date 2022-11-01 17:22
 * 剑指offer68
 * 给定两个二叉树节点node1和node2，找到他们的最低公共祖先节点
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode head, TreeNode node1, TreeNode node2) {
        //base case，如果公共父节点是node1，就返回node1
        if (head == null || head == node1 || head == node2) {
            return head;
        }

        //左右子树的值，为空则没有，不为空则为node上方的节点
        TreeNode left = lowestCommonAncestor(head.left, node1, node2);
        TreeNode right = lowestCommonAncestor(head.right, node1, node2);

        //node1和node2都不为空时，node1和node2分别在左子树和右子树，公共父节点就是当前的head
        if (left != null && right != null) {
            return head;
        }

        //node1和node2里有一个为空，返回left和right中非空的
        return left != null ? left : right;
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

class LowestCommonAncestorTest {
    @Test
    public void lowestCommonAncestorTest() {
        System.out.println("test");
    }
}
