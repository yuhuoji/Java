package com.leetcode.algorithm.day8;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @date 2023-03-07 12:41
 * 广度优先搜索 / 深度优先搜索
 */
public class Leetcode617MergeTwoBinaryTrees {
    //方法一：深度优先搜索 递归
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }
        //都不是空的
        root1.val += root2.val;
        root1.left = mergeTrees1(root1.left, root2.left);
        root1.right = mergeTrees1(root1.right, root2.right);
        return root1;
    }

    //方法二：广度优先搜索 TODO
    //修改root1，保持root1>=root2
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
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
            //left
            if (left2 != null) {
                if (left1 != null) {
                    left1.val += left2.val;
                } else {
                    left1 = new TreeNode(left2.val);
                }
                queue1.offer(left1);
                queue2.offer(left2);
            }
            //left2==null不做处理

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
//        root1 =[1, 3, 2, 5]
//        root2 =[2, 1, 3, null, 4, null, 7]
    }

    public static class TreeNode {
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
