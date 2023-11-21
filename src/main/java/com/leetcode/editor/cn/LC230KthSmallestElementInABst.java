package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Deque;

// 230 Kth Smallest Element in a BST
public class LC230KthSmallestElementInABst {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 230);
        Solution solution = new LC230KthSmallestElementInABst().new Solution();

    }
    // 经常修改:平衡搜索树
    // eg：AVL树
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
        // 中序 栈
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stk = new ArrayDeque<>();
            TreeNode cur = root;
            while (!stk.isEmpty() || cur != null) {
                while (cur != null) {
                    stk.push(cur);
                    cur = cur.left;
                }
                cur = stk.pop();
                k--;
                if (k == 0) {
                    break;
                }
                cur = cur.right;
            }
            return cur.val;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}