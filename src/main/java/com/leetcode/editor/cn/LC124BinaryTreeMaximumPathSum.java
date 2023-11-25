package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// Binary Tree Maximum Path Sum
public class LC124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        System.out.println("LC " + 124);
        Solution solution = new LC124BinaryTreeMaximumPathSum().new Solution();
        //[-1,2,-3]
        //[-10,9,20,null,null,15,7]
        String s = "[1,2,-3]";
        TreeNode root = LeetCodeHelper.stringToTreeNode(s);
        System.out.println(solution.maxPathSum(root));
    }
    //TODO @date 2023-11-22
    //dfs TLE
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int ans;

        //内部：l-root-r
        //给父节点提供，max(l,r)+root
        public int maxPathSum(TreeNode root) {
            ans = Integer.MIN_VALUE / 2;
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int l = dfs(node.left);
            int r = dfs(node.right);
            ans = Math.max(ans, l + r + node.val); //内部
            return Math.max(Math.max(l, r) + node.val, 0); //返回0表示不选
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}