package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 209 Minimum Size Subarray Sum
public class LC209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println("LC " + 209);
        Solution solution = new LC209MinimumSizeSubarraySum().new Solution();

        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution.minSubArrayLen(target, nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 滑动窗口
        // 时间 O(N)
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int sum = 0;
            int ans = n + 1;
            for (int l = 0, r = 0; r < n; ++r) {
                sum += nums[r];
                while (sum >= target) {
                    ans = Math.min(ans, r - l + 1);
                    sum -= nums[l++];
                }
            }
            return ans == n + 1 ? 0 : ans;
        }

        // 暴力枚举 时间O(N^2)
        // 所有元素均为正数
        // 前缀和 + 二分查找 sum[r] - sum[l-1] >= t
        // t+sum[l] <= sum[r+1]
        // 时间O(NlogN)
        public int minSubArrayLen2(int target, int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n + 1]; //[i+1] 表示 0..i的前缀和
            // prefix[0] = 0; //-1的前缀和
            for (int i = 0; i < n; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            int min = n + 1;
            for (int l = 0; l < n; ++l) {
                //[0,r]上找l-1
                int t = target + prefix[l];
                int index = Arrays.binarySearch(prefix, t); // 二分查找
                if (index < 0) {
                    index = ~index;
                }
                if (index <= n) {
                    min = Math.min(min, index - l);
                }
            }
            return min == n + 1 ? 0 : min;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}