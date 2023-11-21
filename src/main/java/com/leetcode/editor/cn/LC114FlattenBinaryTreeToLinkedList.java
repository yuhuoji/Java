package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 114 Flatten Binary Tree to Linked List
public class LC114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 114);
        Solution solution = new LC114FlattenBinaryTreeToLinkedList().new Solution();
        String s = "[1,null,2,3]";
        TreeNode root = LeetCodeHelper.stringToTreeNode(s);
        solution.flatten(root);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
    //  与先序遍历顺序相同
    // 中-》左-》右
// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        // 递归
        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left != null) { // 无左子树，直接处理右子树
                    // 有左子树
                    TreeNode pre = root.left; // 左树上最右的节点
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    pre.right = root.right; // 类似Morris
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}