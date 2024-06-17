package com.leetcode.algorithm.day8;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 2023-03-07 12:41
 * 广度优先搜索 / 深度优先搜索
 * 617. 合并二叉树
 */
public class Leetcode617MergeTwoBinaryTrees {
    /**
     * 方法一：深度优先搜索 递归
     * 前序遍历
     *
     * @param root1 树1
     * @param root2 树2
     * @return 合并后的根节点
     */
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //都不是空的
        root1.val += root2.val;
        root1.left = mergeTrees1(root1.left, root2.left);
        root1.right = mergeTrees1(root1.right, root2.right);
        return root1;
    }

    /**
     * 方法二：广度优先搜索 TODO
     * 修改root1，保持root1>=root2
     *
     * @param root1 树1
     * @param root2 树2
     * @return 合并后的根节点
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //都不是空树
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        root1.val += root2.val;
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            //left2==null不做处理
            if (left2 != null) {
                if (left1 != null) {
                    left1.val += left2.val;
                } else {
                    left1 = new TreeNode(left2.val);
                }
                queue1.offer(left1);
                queue2.offer(left2);
            }

            //right
            if (right2 != null) {
                if (right1 != null) {
                    right1.val += right2.val;
                } else {
                    right1 = new TreeNode(right2.val);
                }
                queue1.offer(right1);
                queue2.offer(right2);
            }
        }

        //更改了root1
        return root1;
    }

    @Test
    public void test() {
        Integer[] tree1 = {1, 3, 2, 5};
        Integer[] tree2 = {2, 1, 3, null, 4, null, 7};
        TreeNode root1 = createTree(tree1);
        TreeNode root2 = createTree(tree2);
        printTree(root1);
        printTree(root2);
//        TreeNode mergedRoot = mergeTrees2(root1, root2);
    }

    /**
     * leetcode根据一维Integer数组创建树
     *
     * @param array 数组
     * @return 根节点
     */
    public TreeNode createTree(Integer[] array) {
        TreeNode root = createTree(array, 1);
        return root;
    }

    /**
     * 递归创建二叉树
     *
     * @param array 数组
     * @param index 当前节点
     * @return 新创建的当前节点
     */
    private TreeNode createTree(Integer[] array, int index) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    /**
     * 打印树
     *
     * @param root 根节点
     */
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printBinaryTree(root);
    }

    /**
     * 数组打印二叉树
     *
     * @param root 根节点
     */
    private void printBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); //ArrayDeque用offer添加时检查不准添加null，LinkedList添加补进行检查
        queue.offer(root);
        System.out.print("BinaryTree: [");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + ", ");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                System.out.print("null, ");
            }
        }
        System.out.println("]");
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
