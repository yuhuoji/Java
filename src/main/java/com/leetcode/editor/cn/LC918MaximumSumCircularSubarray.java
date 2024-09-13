package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 918 环形子数组的最大和
public class LC918MaximumSumCircularSubarray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 918);
        Solution solution = new LC918MaximumSumCircularSubarray().new Solution();

    }

    // REVIEW @date 2024-07-11 最大子数组和（最大子段和）
    // 1191
    // 非空子数组 分类讨论 正难则反
    // 1. 不跨越边界 lc53
    // 2. 跨越边界 子数组和+其他元素和=sum(nums)，求其他元素最小时minSum
    // minSum=sum(nums),子数组为空,不能为空，返回1.的结果
    // 最大子数组和不能为空，最小子数组和可以为空(其他元素和)
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int minSum = 0;
            int maxOfEnd = 0, minOfEnd = 0, sum = 0;
            for (int x : nums) {
                maxOfEnd = Math.max(maxOfEnd, 0) + x; // 选或不选
                maxSum = Math.max(maxSum, maxOfEnd);
                minOfEnd = Math.min(minOfEnd, 0) + x;
                minSum = Math.min(minSum, minOfEnd);
                sum += x;
            }
            return minSum == sum ? maxSum : Math.max(maxSum, sum - minSum); // 最小子数组是整个数组
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}