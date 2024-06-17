package com.bilibili40.chapter06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树BST
 *
 * @date 2022-10-29 11:22
 * <p>
 * TODO 树形dp （迭代？）
 */
public class BinarySearchTree {
    private int preValue = Integer.MIN_VALUE;

    public boolean checkBST(TreeNode head) {
        if (head == null) {
            return true;
        }

        // 遍历左子树
        boolean isLeftBST = checkBST(head.left);
        if (!isLeftBST) {
            return false;
        }

        if (head.value <= preValue) {  // 判断是否有序
            return false;
        } else {
            preValue = head.value; // 更新preValue，继续遍历
        }

        // 遍历右子树
        return checkBST(head.right);
    }

    public boolean checkBST2(TreeNode head) {
        List<TreeNode> inOrderList = new ArrayList<>();
        checkBST2Process(head, inOrderList);
        inOrderList.forEach(item -> System.out.println(item + " "));
        for (int i = 0; i < inOrderList.size() - 1; i++) { // 0 -> n-2
            if (inOrderList.get(i).value > inOrderList.get(i + 1).value) {
                return false;
            }
        }
        return true;
    }

    // 二叉树中序遍历递归
    private void checkBST2Process(TreeNode head, List<TreeNode> inOrderList) {
        if (head == null) {
            return;
        }
        checkBST2Process(head.left, inOrderList);
        inOrderList.add(head);
        checkBST2Process(head.right, inOrderList);
    }

    // inOrderTraversalNonRecursive
    public boolean checkBST3(TreeNode head) {
        System.out.println("inOrderTraversalNonRecursive");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            int preValue = Integer.MIN_VALUE;
            while (!stack.isEmpty() || head != null) { //
                if (head != null) { // 检查left or right
                    stack.push(head);
                    head = head.left; // 检查左子树
                } else {
                    head = stack.pop();
                    if (head.value <= preValue) { // 当前节点的值比上一个遍历到的节点的值小
                        return false;
                    } else {
                        preValue = head.value; // 更新preValue，继续遍历
                    }
                    head = head.right; // 检查右子树
                }
            }
        }
        return true;
    }

    /* 做法同bilibili左神 */
    public Result process4(TreeNode head) {
        // base case
        if (head == null) {
            return null;
        }

        // 二叉树递归，获取左树信息右树信息，左树信息+右树信息=父节点信息，返回给调用
        Result leftData = process4(head.left);
        Result rightData = process4(head.right);
        // 根据所获子节点信息进行判断并返回值
        int min = head.value; // 最小值为左树最小，右树最小和父节点的最小值
        int max = head.value;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        boolean isBST = true; // 默认为true，看是否违规
        if (leftData != null && (!leftData.isBST || leftData.max > head.value)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || head.value > rightData.min)) {
            isBST = false;
        }
        return new Result(isBST, min, max);
    }

    @Test
    public void binarySearchTreeTest() {

    }

    // process4递归返回值类型
    private static class Result {
        boolean isBST; // 是否为搜索二叉树
        int max; // 当前树的最大值
        int min; // 当前树的最小值

        Result(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
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
    }
}
