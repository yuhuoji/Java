package com.leetcode.editor.cn;

import com.bilibili40.chapter06.SuccessorNode;
import com.leetcode.helper.*;

import java.util.IllegalFormatCodePointException;

// 450 删除二叉搜索树中的节点
public class LC450DeleteNodeInABst {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 450);
        Solution solution = new LC450DeleteNodeInABst().new Solution();

    }
    // REVIEW @date 2024-06-24
    // 前驱或者后继替换
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
        // 迭代
        // 根据待删除结点的位置分类讨论
        // 叶节点
        // 有一个子节点
        // 有两个子节点
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode cur = root, parent = null; // 保存删除节点的父节点
            while (cur != null && cur.val != key) {
                parent = cur; // 保存父节点
                if (cur.val > key) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            // 待删除节点不存在
            if (cur == null) {
                return root;
            }
            // 待删除节点存在
            if (cur.left == null && cur.right == null) { // 叶节点
                cur = null;
            } else if (cur.left == null) { // 有一个子节点
                cur = cur.right;
            } else if (cur.right == null) {
                cur = cur.left;
            } else {
                TreeNode successor = cur.right, successorParent = cur; // 用后继替换
                // 找到后继
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }
                // 删除后继
                if (successorParent.val == cur.val) { // cur的右子节点就是后继
                    successorParent.right = successor.right;
                } else {
                    successorParent.left = successor.right;
                }
                // 用后继替换被删除的节点
                successor.left = cur.left;
                successor.right = cur.right;
                cur = successor; // 用后继替换
            }
            // 父节点的引用
            if (parent == null) {
                return cur;
            } else {
                if (parent.left != null && parent.left.val == key) {
                    parent.left = cur;
                } else {
                    parent.right = cur;
                }
                return root;
            }
        }

        // 递归
        public TreeNode deleteNode1(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
                return root;
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
                return root;
            }
            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    return null;
                }
                // 当前节点需要被删除
                if (root.left == null) {
                    return root.right;
                }
                if (root.right == null) {
                    return root.left;
                }
                TreeNode precursor = root.left; // 前驱节点
                while (precursor.right != null) {
                    precursor = precursor.right;
                }
                root.left = deleteNode(root.left, precursor.val);
                precursor.left = root.left;
                precursor.right = root.right;
                return precursor;
            }
            return root;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}