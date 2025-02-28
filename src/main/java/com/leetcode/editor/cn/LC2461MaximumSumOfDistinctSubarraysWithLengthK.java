package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2461 长度为 K 子数组中的最大和
public class LC2461MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "2461");
        Solution solution = new LC2461MaximumSumOfDistinctSubarraysWithLengthK().new Solution();
//[1,5,4,2,9,9,9]
// 			3
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(solution.maximumSubarraySum(nums, k));
    }

    // lc2841
    // 所有元素各不相同 mp.size=k

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            long maxSum = 0L, sum = 0L; // float f 使用大写L避免混淆
            int n = nums.length;
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                // 进入窗口
                int in = nums[i];
                sum += in;
                mp.merge(in, 1, Integer::sum);
                if (i < k - 1) {
                    continue;
                }
                if (mp.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }
                // 离开窗口
                int out = nums[i - k + 1];
                sum -= out;
                if (mp.merge(out, -1, Integer::sum) == 0) {
                    mp.remove(out);
                }
            }
            return maxSum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}