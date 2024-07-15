package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 2321 拼接数组的最大分数
public class LC2321MaximumScoreOfSplicedArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2321);
        Solution solution = new LC2321MaximumScoreOfSplicedArray().new Solution();

    }

    // REVIEW @date 2024-07-15 lc51最大子数组和变形
    // 假设选nums1，从nums2中选部分
    // sum1+diff[l..r], diff=nums2-nums1
    // 需要求diff数组的最大子数组和（允许子数组为空）
    // 返回两种情况中最大的结果

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumsSplicedArray(int[] nums1, int[] nums2) {
            return Math.max(maxSubArray(nums1, nums2), maxSubArray(nums2, nums1));
        }

        public int maxSubArray(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int sum1 = 0; // 同时计算sum1的和
            int maxOfEnd = 0, maxSum = 0; // 允许子数组为空
            for (int i = 0; i < n; ++i) {
                sum1 += nums1[i];
                int x = nums2[i] - nums1[i];
                maxOfEnd = Math.max(x, maxOfEnd + x);
                maxSum = Math.max(maxSum, maxOfEnd);
            }
            return sum1 + maxSum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}