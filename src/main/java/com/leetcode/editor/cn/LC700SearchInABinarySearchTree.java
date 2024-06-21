package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 700 二叉搜索树中的搜索
public class LC700SearchInABinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 700);
        Solution solution = new LC700SearchInABinarySearchTree().new Solution();

    }
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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}