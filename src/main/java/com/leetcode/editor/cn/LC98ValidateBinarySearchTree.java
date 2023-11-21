package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 98 Validate Binary Search Tree
public class LC98ValidateBinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 98);
        Solution solution = new LC98ValidateBinarySearchTree().new Solution();
        String s = "[2,1,3]";
        System.out.println(solution.isValidBST(LeetCodeHelper.stringToTreeNode(s)));
    }
    // REVIEW @date 2023-11-21
    // 用栈迭代
    // 数据范围 Long
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

    // 迭代 中序
    // 栈
    class Solution {
        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stk = new LinkedList<>();
            TreeNode cur = root;
            long pre = Long.MIN_VALUE; // 维护上一个值
            while (!stk.isEmpty() || cur != null) {
                while (cur != null) {
                    stk.push(cur);
                    cur = cur.left;
                }
                cur = stk.pop();
                if (pre >= cur.val) {
                    return false;
                }
                pre = cur.val;
                cur = cur.right;
            }
            return true;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

    // 后序
    // 先遍历左右子树，再判断
    // 需要子树返回最大值和最小值
    class Solution3 {
        public boolean isValidBST(TreeNode root) {
            return dfs(root)[1] != Long.MAX_VALUE; // 返回最大值表示不是二叉搜索树
        }

        private long[] dfs(TreeNode node) {
            if (node == null) {
                return new long[]{Long.MAX_VALUE, Long.MIN_VALUE}; // 表示是二叉搜索树
            }
            long val = node.val;
            long[] left = dfs(node.left);
            if (left[1] >= val) {
                return new long[]{Long.MIN_VALUE, Long.MAX_VALUE}; // 表示不是二叉搜索树
            }
            long[] right = dfs(node.right);
            if (val >= right[0]) {
                return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
            }
            // 是二叉搜索树
            return new long[]{Math.min(left[0], val), Math.max(val, right[1])};// 因为空节点返回{最大，最小}表示true
        }
    }

    // 中序
    // 左 < 中 < 右
    class Solution2 {
        private long pre = Long.MIN_VALUE; // 用pre维护上个数

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left) || pre >= root.val) {
                return false;
            }
            pre = root.val;
            return isValidBST(root.right);
        }
    }

    // 前序遍历
    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        boolean isValidBST(TreeNode node, long left, long right) {
            if (node == null) {
                return true;
            }
            long val = node.val;
            return left < val && val < right && isValidBST(node.left, left, val) && isValidBST(node.right, val, right);
        }
    }
}