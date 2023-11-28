package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.Map;

// 106 Construct Binary Tree from Inorder and Postorder Traversal
public class LC106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 106);
        Solution solution = new LC106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();

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
        private Map<Integer, Integer> mp;
        private int[] inorder;
        private int[] postorder;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            this.postorder = postorder;
            this.inorder = inorder;
            mp = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                mp.put(inorder[i], i);
            }
            return buildProcess(0, n - 1, 0, n - 1);
        }

        //[]
        private TreeNode buildProcess(int in_i, int in_j, int post_i, int post_j) {
            if (post_i > post_j) {
                return null;
            }
            int root_val = postorder[post_j];
            TreeNode root = new TreeNode(root_val); // 根
            int root_idx = mp.get(root_val);
            int l_size = root_idx - in_i;
            int r_size = in_j - root_idx;
            root.left = buildProcess(in_i, root_idx - 1, post_i, post_i + l_size - 1);
            root.right = buildProcess(root_idx + 1, in_j, post_i + l_size, post_j - 1);
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}