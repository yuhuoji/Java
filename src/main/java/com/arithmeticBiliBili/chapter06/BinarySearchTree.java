package com.arithmeticBiliBili.chapter06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树BST
 *
 * @date 2022-10-29 11:22
 */
public class BinarySearchTree {
    private int preValue = Integer.MIN_VALUE;

    public boolean checkBST(TreeNode head) {
        if (head == null) {
            return true;

        }

        //遍历左子树
        boolean isLeftBST = checkBST(head.left);
        if (!isLeftBST) {
            return false;
        }

        if (head.value <= preValue) {  //判断是否有序
            return false;
        } else {
            preValue = head.value; //更新preValue，继续遍历
        }

        //遍历右子树
        return checkBST(head.right);
    }

    public boolean checkBST2(TreeNode head) {
        List<TreeNode> inOrderList = new ArrayList<>();
        checkBST2Process(head, inOrderList);
        inOrderList.forEach(item -> System.out.println(item + " "));
        for (int i = 0; i < inOrderList.size() - 1; i++) { //0 -> n-2
            if (inOrderList.get(i).value > inOrderList.get(i + 1).value) {
                return false;
            }
        }
        return true;
    }

    //二叉树中序遍历递归
    private void checkBST2Process(TreeNode head, List<TreeNode> inOrderList) {
        if (head == null) {
            return;
        }
        checkBST2Process(head.left, inOrderList);
        inOrderList.add(head);
        checkBST2Process(head.right, inOrderList);
    }

    //inOrderTraversalNonRecursive
    public boolean checkBST3(TreeNode head) {
        System.out.println("inOrderTraversalNonRecursive");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            int preValue = Integer.MIN_VALUE;
            while (!stack.isEmpty() || head != null) { //
                if (head != null) { //检查left or right
                    stack.push(head);
                    head = head.left; //检查左子树
                } else {
                    head = stack.pop();
                    if (head.value<=preValue){ //当前节点的值比上一个遍历到的节点的值小
                        return false;
                    }else {
                        preValue = head.value; //更新preValue，继续遍历
                    }
                    head = head.right; //检查右子树
                }
            }
        }
        return  true;
    }

    @Test
    public void binarySearchTreeTest() {

    }

    private static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }
}
