package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 199 Binary Tree Right Side View
public class LC199BinaryTreeRightSideView {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 199);
        Solution solution = new LC199BinaryTreeRightSideView().new Solution();
        String s = "[1,2,3,null,5,null,4]";
        System.out.println(solution.rightSideView(LeetCodeHelper.stringToTreeNode(s)));
    }
    // 1.bfs/层序 记录最后一个
    // 2.dfs
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
        // dfs
        private List<Integer> ans;

        public List<Integer> rightSideView2(TreeNode root) {
            ans = new ArrayList<>();
            dfs(root, 0);
            return ans;
        }

        // 中 -》 右 -》 左
        private void dfs(TreeNode node, int depth) {
            if (node == null) {
                return;
            }
            if (depth == ans.size()) {
                ans.add(node.val);
            }
            depth++;
            dfs(node.right, depth);
            dfs(node.left, depth);
        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) { //queue不接受null
                return ans;
            }
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; ++i) {
                    TreeNode cur = q.poll();
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                    if (i == sz - 1) {
                        ans.add(cur.val); // 每层最后一个
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}