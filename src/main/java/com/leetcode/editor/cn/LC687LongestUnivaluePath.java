package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// Longest Univalue Path
public class LC687LongestUnivaluePath {
    public static void main(String[] args) {
        System.out.println("LC " + 687);
        Solution solution = new LC687LongestUnivaluePath().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans;
        int dfs(TreeNode node, int fa) {
            if (node == null) {
                return 0;
            }
            int val = node.val;
            int l = dfs(node.left, val);
            int r = dfs(node.right, val);

            if (node.left != null && node.left.val == val) {
                l++;
            }
            if (node.right != null && node.right.val == val) {
                r++;
            }
            ans = Math.max(ans, l + r);
            if (node.val != fa) {
                return 0;
            }
            return Math.max(l, r);
        }

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) return 0;
            ans = 0;
//            dfs(root);
            dfs(root, root.val);
            return ans;
        }

        int dfs(TreeNode node) {
            if (node == null) {
                return -1;
            }
            int val = node.val;
            int l = dfs(node.left) + 1;
            int r = dfs(node.right) + 1;
            if (node.left != null && node.left.val != val) { //不相等则长度无效
                l = 0;
            }
            if (node.right != null && node.right.val != val) {
                r = 0;
            }
            ans = Math.max(ans, l + r);
            return Math.max(l, r); //返回给父节点的最长链
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}