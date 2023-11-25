package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

// 437 Path Sum III
public class LC437PathSumIii {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 437);
        Solution solution = new LC437PathSumIii().new Solution();
        String s = "[10,5,-3,3,2,null,11,3,-2,null,1]";
        int targetSum = 8;
        System.out.println(solution.pathSum(LeetCodeHelper.stringToTreeNode(s), targetSum));
    }
    //REVIEW @date 2023-11-22
    // 前缀和 sum
    // 回溯 mp 恢复现场
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
    long sum;// 根到当前节点路上的前缀和
    Map<Long, Integer> mp;
    int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        sum = 0;
        mp = new HashMap<>();
        this.targetSum = targetSum;
        mp.put(0L, 1); // 和为0的数量为1
        return dfs(root);
    }

    // dfs(root) = 到当前节点 + 左 + 右
    // 存在几个sum - targetSum
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sum += root.val; // 前缀和
        int cnt = 0;
        cnt += mp.getOrDefault(sum - targetSum, 0); // 到当前点的
        mp.put(sum, mp.getOrDefault(sum, 0) + 1); // 记录当前前缀和
        // 递归
        cnt += dfs(root.left); // 左
        cnt += dfs(root.right); // 右
        // 恢复现场
        mp.put(sum, mp.get(sum) - 1);
        sum -= root.val;
        return cnt;
    }
}
// leetcode submit region end(Prohibit modification and deletion)

}