package com.bilibili40.chapter13;

import org.junit.Test;

/**
 * Morris遍历
 * 假设来到当前节点cur，开始时来到头节点位置
 * 1）如果cur没有左孩子，cur向右移动（cur = cur.right）
 * 2）如果cur有左孩子，找到左子树上最右的节点mostRight：
 * a）如果mostRight的右指针指向空，让其指向cur，然后向左移动（cur = cur.left）
 * b）如果mostRight的右指针指向cur，让其指向null，然后cur向右移动（cur = cur.right）
 * 3）cur为空时遍历停止
 * <p>
 * 有左树的节点会遍历两次，其余节点遍历一次
 */
public class MorrisTransversal {
    /**
     * Morris遍历
     *
     * @param head 根节点
     */
    public void morris(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head; //开始时来到头节点位置
        TreeNode mostRight = null;
        while (cur != null) { //cur为空时遍历停止
            mostRight = cur.left;
            if (mostRight != null) { //如果cur有左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right; //找到左子树上最右的节点
                }
                //已经找到左子树上的最右节点mostRight
                if (mostRight == null) { //第一次来到cur
                    mostRight.right = cur;
                    cur = cur.right;
                    continue;
                } else { //只遍历一次的节点，或mostRight.right = cur，第二次来到cur
                    mostRight.right = null;
                }
            }
            cur = cur.right; //如果cur没有左孩子，cur向右移动
        }
    }

    /**
     * Morris遍历改先序遍历
     * 遍历一次的节点直接打印，遍历两次的节点第一次就打印
     *
     * @param head 根节点
     */
    public void morrisPre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head; //开始时来到头节点位置
        TreeNode mostRight = null;
        while (cur != null) { //cur为空时遍历停止
            mostRight = cur.left;
            if (mostRight != null) { //如果cur有左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right; //找到左子树上最右的节点
                }
                //已经找到左子树上的最右节点mostRight
                if (mostRight == null) { //第一次来到cur
                    System.out.println(cur.val + " "); //先序遍历第一次来到节点就打印
                    mostRight.right = cur;
                    cur = cur.right;
                    continue;
                } else { //只遍历一次的节点，或mostRight.right = cur，第二次来到cur
                    mostRight.right = null;
                }
            } else { //无左子树
                System.out.println(cur.val + " ");
            }
            cur = cur.right; //如果cur没有左孩子，cur向右移动
        }
    }

    /**
     * Morris遍历改中序遍历
     * 遍历一次的节点直接打印，遍历两次的节点第二次再打印
     *
     * @param head 根节点
     */
    public void morrisIn(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head; //开始时来到头节点位置
        TreeNode mostRight = null;
        while (cur != null) { //cur为空时遍历停止
            mostRight = cur.left;
            if (mostRight != null) { //如果cur有左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right; //找到左子树上最右的节点
                }
                //已经找到左子树上的最右节点mostRight
                if (mostRight == null) { //第一次来到cur
                    mostRight.right = cur;
                    cur = cur.right;
                    continue; //
                } else { //只遍历一次的节点，或mostRight.right = cur，第二次来到cur
                    mostRight.right = null;
                }
            }
            System.out.println(cur.val + " "); //
            cur = cur.right; //如果cur没有左孩子，cur向右移动
        }
    }

    /**
     * 只在第二次回到节点时逆序打印左树的右边界
     * 最后单独逆序打印整棵树的右边界
     *
     * @param head
     */
    public void morrisPost(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head; //开始时来到头节点位置
        TreeNode mostRight = null;
        while (cur != null) { //cur为空时遍历停止
            mostRight = cur.left;
            if (mostRight != null) { //如果cur有左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right; //找到左子树上最右的节点
                }
                //已经找到左子树上的最右节点mostRight
                if (mostRight == null) { //第一次来到cur
                    mostRight.right = cur;
                    cur = cur.right;
                    continue;
                } else { //只遍历一次的节点，或mostRight.right = cur，第二次来到cur
                    mostRight.right = null;
                    printRightEdge(cur.left); //打印左树右边界
                }
            }
            cur = cur.right; //如果cur没有左孩子，cur向右移动
        }
        printRightEdge(head); //打印整棵树右边界
    }

    /**
     * 以node为头的树，逆序打印右边界
     * 先逆序，再打印，最后再逆序还原
     *
     * @param node 根节点
     */
    private void printRightEdge(TreeNode node) {
        TreeNode tail = reverseEdge(node); //先逆序
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail); //最后还原
    }

    /**
     * 翻转当前树的右边界
     * @param from 当前节点
     * @return 翻转后第一个节点
     */
    private TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    @Test
    public void test() {

    }

    private static class TreeNode {
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
