package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 1161 最大层内元素和
public class LC1161MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1161);
        Solution solution = new LC1161MaximumLevelSumOfABinaryTree().new Solution();

    }

    // 层序遍历

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
        private int mx;
        private int level;

        public int maxLevelSum(TreeNode root) {
            mx = root.val;
            level = 1;
            levelOrder(root);
            return level;
        }

        public void levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return;
            }
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            int curLevel = 1; // 当前所处层数
            while (!q.isEmpty()) {
                int size = q.size();
                int sum = 0;
                for (int i = 0; i < size; ++i) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                if (sum > mx) {
                    mx = sum;
                    level = curLevel;
                }
                curLevel++;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}