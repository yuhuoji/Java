package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1448 统计二叉树中好节点的数目
public class LC1448CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1448);
        Solution solution = new LC1448CountGoodNodesInBinaryTree().new Solution();

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
        private int ans = 0;

        public int goodNodes(TreeNode root) {
            int mx = root.val;
            dfs(root, mx);
            return ans;
        }

        private void dfs(TreeNode root, int max) {
            if (root.val >= max) {
                ans++;
            }
            max = Math.max(max, root.val);
            if (root.left != null) {
                dfs(root.left, max);
            }
            if (root.right != null) {
                dfs(root.right, max);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}