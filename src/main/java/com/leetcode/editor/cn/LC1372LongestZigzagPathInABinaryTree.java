package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1372 Longest ZigZag Path in a Binary Tree
public class LC1372LongestZigzagPathInABinaryTree {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1372);
        Solution solution = new LC1372LongestZigzagPathInABinaryTree().new Solution();
        // String s = "[6,9,7,3,null,2,8,5,8,9,7,3,9,9,4,2,10,null,5,4,3,10,10,9,4,1,2,null,null,6,5,null,null,null,null,9,null,9,6,5,null,5,null,null,7,7,4,null,1,null,null,3,7,null,9,null,null,null,null,null,null,null,null,9,9,null,null,null,7,null,null,null,null,null,null,null,null,null,6,8,7,null,null,null,3,10,null,null,null,null,null,1,null,1,2]";
        String s = "[1]";
        System.out.println(solution.longestZigZag(LeetCodeHelper.stringToTreeNode(s)));
    }

    // 树型dp
    // 可以考虑是否包括当前节点。
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int mx;

        public int longestZigZag(TreeNode root) {
            if (root == null) {
                return 0;
            }
            mx = 0;
            dfs(root, 0, 0);
            return mx;
        }

        // dfs到当前节点时，l为该节点是左子树的路径数。l和r只有一个有值
        private void dfs(TreeNode node, int l, int r) {
            mx = Math.max(mx, Math.max(l, r));
            if (node.left != null) {
                dfs(node.left, r + 1, 0); // 祖父 - 右 - 左
            }
            if (node.right != null) {
                dfs(node.right, 0, l + 1);
            }
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        // dfs维护最大值，返回以node为根节点的路径长度（可能不是最长）
        private int mx;

        public int longestZigZag(TreeNode root) {
            mx = 0;
            dfs(root, 0);
            dfs(root, 1);
            return mx;
        }

        // l=0, r=1
        // 返回以node为根节点的路径长度（可能不是最长）
        private int dfs(TreeNode node, int dir) {
            if (node == null) {
                return 0;
            }
            int l = dfs(node.left, 0);
            int r = dfs(node.right, 1);
            mx = Math.max(mx, l);
            mx = Math.max(mx, r);
            // 当前节点是祖父节点的左子节点就返回r+1
            return dir == 0 ? r + 1 : l + 1;
        }
    }
}