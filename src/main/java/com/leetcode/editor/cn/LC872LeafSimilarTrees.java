package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.List;

// 872 叶子相似的树
public class LC872LeafSimilarTrees {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 872);
        Solution solution = new LC872LeafSimilarTrees().new Solution();

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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            if (root1 != null) {
                dfs(root1, list1);
            }
            List<Integer> list2 = new ArrayList<>();
            if (root2 != null) {
                dfs(root2, list2);
            }
            return list1.equals(list2);
        }

        private void dfs(TreeNode root, List<Integer> list) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
            } else {
                if (root.left != null) {
                    dfs(root.left, list);
                }
                if (root.right != null) {
                    dfs(root.right, list);
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}