package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// House Robber III
public class LC337HouseRobberIii {
    //dp 树上最大独立集
    public static void main(String[] args) {
        System.out.println("LC " + 337);
        Solution solution = new LC337HouseRobberIii().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //当前节点 = max{选当前节点:val+sum{不选子节点}， 不选当前节点:sum{子节点可选可不选}}
        public int rob(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        //select, not select
        int[] dfs(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0};
            }
            int[] l = dfs(node.left);
            int[] r = dfs(node.right);
            int select = node.val + l[1] + r[1];//选当前节点
            int notSelect = Math.max(l[0], l[1]) + Math.max(r[0], r[1]); //子节点可选可不选
            return new int[]{select, notSelect};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}