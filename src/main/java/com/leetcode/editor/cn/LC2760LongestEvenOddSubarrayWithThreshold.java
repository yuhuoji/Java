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
    // https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/solutions/2528771/jiao-ni-yi-ci-xing-ba-dai-ma-xie-dui-on-zuspx/
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int n = nums.length;
            int ans = 0;
            int i = 0;
            while (i < n) {
                if (nums[i] % 2 != 0 || nums[i] > threshold) { // 不满足要求，直接跳过
                    i++;
                    continue;
                }
                int start = i;// 这一组的开始位置
                i++;
                while (i < n && nums[i] <= threshold && nums[i] % 2 != nums[i - 1] % 2) { // 找本组结束位置
                    i++;
                }
                // 本组[start, i-1]
                ans = Math.max(ans, i - start);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}