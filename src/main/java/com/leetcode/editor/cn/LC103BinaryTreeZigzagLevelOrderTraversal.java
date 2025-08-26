package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 103 二叉树的锯齿形层序遍历
public class LC103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "103");
        Solution solution = new LC103BinaryTreeZigzagLevelOrderTraversal().new Solution();

    }

    // TODO @date 2025-08-22
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            boolean even = false; // 判断是否是奇数层，奇数层需要翻转
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> vals = new ArrayList<>(size);
                for (int i = 0; i < size; ++i) {
                    TreeNode cur = q.poll();
                    vals.add(cur.val);
                    if (cur.left != null) {
                        q.add(cur.left);
                    }
                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                }
                if (even) {
                    Collections.reverse(vals);
                }
                even = !even;
                ans.add(vals);
            }
            return ans;
        }

        // 先收集，然后反转偶数层
        public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
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
            int len = ans.size();
            for (int i = 1; i < len; i += 2) {
                List<Integer> list = ans.get(i);
                Collections.reverse(list);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}