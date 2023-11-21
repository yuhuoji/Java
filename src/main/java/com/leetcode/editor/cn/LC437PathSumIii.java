package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.nio.file.Paths;

// 437 Path Sum III
public class LC437PathSumIii {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 437);
        Solution solution = new LC437PathSumIii().new Solution();

    }
    // TODO @date 2023-11-21
    // dp?
    // 有负数
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
        int INF = Integer.MIN_VALUE/2;
        public int pathSum(TreeNode root, int targetSum) {
            return dfs(root, targetSum);
        }

        //包括root
        //不包括root, 左 or 右
        private int dfs(TreeNode root, int targetSum) {
            if (root==null){

            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}