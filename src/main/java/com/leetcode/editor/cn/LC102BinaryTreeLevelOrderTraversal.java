package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 102 二叉树的层序遍历
public class LC102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 102);
        Solution solution = new LC102BinaryTreeLevelOrderTraversal().new Solution();

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                ans.add(new ArrayList<>());
                for (int i = 0; i < size; ++i) {
                    TreeNode cur = q.poll();
                    ans.getLast().add(cur.val);
                    if (cur.left != null) {
                        q.add(cur.left);
                    }
                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}