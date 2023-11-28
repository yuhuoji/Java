package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.List;

// 236 Lowest Common Ancestor of a Binary Tree
public class LC236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 236);
        Solution solution = new LC236LowestCommonAncestorOfABinaryTree().new Solution();
        String s = "[3,5,1,6,2,0,8,null,null,7,4]";
        TreeNode root = LeetCodeHelper.stringToTreeNode(s);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
    }
    // REVIEW @date 2023-11-22
    // root为LCA: 三种情况 分列两侧，root为p，root为q
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
        // root为LCA: 三种情况 分列两侧，root为p，root为q
        //
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) { // root为p，root为q
                return root;
            }
            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);
            if (l == null && r == null) {
                return null;
            }
            if (l == null) { // r!=null, r是LCA
                return r;
            }
            if (r == null) {
                return l;
            }
            // 左右都有，返回root
            return root;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}