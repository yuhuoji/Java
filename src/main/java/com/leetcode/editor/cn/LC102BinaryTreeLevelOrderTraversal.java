package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                ans.add(new ArrayList<>());
                for (int i = 0; i < size; ++i) {
                    TreeNode node = q.poll();
                    ans.get(ans.size() - 1).add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}