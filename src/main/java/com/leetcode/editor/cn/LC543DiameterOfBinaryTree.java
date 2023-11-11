package com.leetcode.editor.cn;

import com.leetcode.helper.*;

public class LC543DiameterOfBinaryTree {
    //树形dp
    public static void main(String[] args) {
        System.out.println("LC " + 543);
        Solution solution = new LC543DiameterOfBinaryTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
    //边
    class Solution {
        private int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            this.ans = 0;
            dfs(root);
            return ans;
        }

        //当前点的高度
        private int dfs(TreeNode node) {
            if (node == null) {
                return -1;
            }
            int l = dfs(node.left);
            int r = dfs(node.right);
            this.ans = Math.max(this.ans, l + r + 2); //在当前节点拐弯
            return Math.max(l, r) + 1; //当前节点的最长链
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}