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
    // TODO @date 2024-06-21
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
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode cur = root, parent = null;
            while (cur != null && cur.val != key) {
                if (cur.val < key) {
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
            // 找到节点或不存在
            if (cur == null) {
                return null;
            }
            if (cur.left == null && cur.right == null) {
                cur = null;
                return root;
            } else if (cur.left == null) {

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