package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2760 Longest Even Odd Subarray With Threshold
public class LC2760LongestEvenOddSubarrayWithThreshold {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2760);
        Solution solution = new LC2760LongestEvenOddSubarrayWithThreshold().new Solution();

    }

    // 分组循环
    // 外层循环负责遍历组之前的准备工作（记录开始位置），和遍历组之后的统计工作（更新答案最大值）。
    // 内层循环负责遍历组，找出这一组最远在哪结束。
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0, start; i < n; ) {
                if (nums[i] % 2 != 0 || nums[i] > threshold) { // 直接跳过
                    i++;
                    continue;
                }
                start = i; // 本组起点
                i++; //
                while (i < n && nums[i] <= threshold && nums[i - 1] % 2 != nums[i] % 2) {
                    i++;
                }
                ans = Math.max(ans, i - start); // [start,i-1]
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}