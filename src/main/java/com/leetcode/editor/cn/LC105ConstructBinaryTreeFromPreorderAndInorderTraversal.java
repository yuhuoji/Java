package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.Map;

// 105 Construct Binary Tree from Preorder and Inorder Traversal
public class LC105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 105);
        Solution solution = new LC105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();

    }
    // 中序
    // 没有重复的
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
        private int[] preorder;
        private int[] inorder;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            this.preorder = preorder;
            this.inorder = inorder;
            mp = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                mp.put(inorder[i], i);
            }
            return buildProcess(0, n - 1, 0, n - 1);
        }

        //[]
        private TreeNode buildProcess(int pre_i, int pre_j, int in_i, int in_j) {
            if (pre_i > pre_j) {
                return null;
            }
            int root_val = preorder[pre_i];
            TreeNode root = new TreeNode(root_val); // 根
            int root_idx = mp.get(root_val);
            int l_size = root_idx - in_i;
            int r_size = in_j - root_idx;
            root.left = buildProcess(pre_i + 1, pre_i + l_size, in_i, root_idx - 1);
            root.right = buildProcess(pre_i + l_size + 1, pre_j, root_idx + 1, in_j);
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}