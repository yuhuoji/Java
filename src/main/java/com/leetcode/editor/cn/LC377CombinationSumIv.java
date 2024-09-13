package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 377 组合总和 Ⅳ
public class LC377CombinationSumIv {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 377);
        Solution solution = new LC377CombinationSumIv().new Solution();

    }

    // REVIEW @date 2024-07-09
    // 从头开始爬楼梯，爬到楼顶，和为target
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // f[i] = sum 0..n-1 f[i-num[j]] 如果跳过num[j]>i
        // 返回f[target]
        // f[0]=1
        public int combinationSum4(int[] nums, int target) {
            int n = nums.length;
            int[] f = new int[target + 1];
            f[0] = 1;
            for (int i = 1; i <= target; ++i) {
                int sum = 0;
                for (int num : nums) {
                    if (num <= i) {
                        sum += f[i - num];
                    }
                }
                f[i] = sum;
            }
            return f[target];
        }
    }

    class Solution1 {

        // 递归+记忆化搜索
        public int combinationSum4(int[] nums, int target) {
            int n = nums.length;
            int[] memo = new int[target + 1];
            Arrays.fill(memo, -1);
            memo[0] = 1;
            return dfs(target, nums, memo);
        }

        // dfs(i) = sum 0..n-1 dfs(i-num[j]) 如果跳过num[j]>i
        // 入口 dfs(target)
        // dfs(0)=1
        private int dfs(int i, int[] nums, int[] memo) {
            if (i == 0) { // 结束
                return 1;
            }
            if (memo[i] != -1) { // 搜索过
                return memo[i];
            }
            int sum = 0;
            for (int num : nums) {
                if (num <= i) {
                    sum += dfs(i - num, nums, memo);
                }
            }
            memo[i] = sum; // 记忆
            return memo[i];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}