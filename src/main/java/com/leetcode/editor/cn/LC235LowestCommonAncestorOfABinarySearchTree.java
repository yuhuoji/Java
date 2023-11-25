package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 235 Lowest Common Ancestor of a Binary Search Tree
public class LC235LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 235);
        Solution solution = new LC235LowestCommonAncestorOfABinarySearchTree().new Solution();

    }
// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 都在左子树
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            // 都在右子树
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            // pq分别在左右子树or当前节点是p或q
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}