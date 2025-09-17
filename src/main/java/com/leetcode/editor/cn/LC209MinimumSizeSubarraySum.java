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

    // REVIEW @date 2025-09-12 前缀和+二分

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 前缀和
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int[] pre = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                pre[i + 1] += pre[i] + nums[i];
            }
            int ans = n + 1;
            for (int right = 0; right < n; ++right) { // 枚举右，寻找左
                int requiredSum = pre[right + 1] - target; // 从[0..r]中找这个l
                int index = Arrays.binarySearch(pre, 0, right + 1, requiredSum); // 找满足pre[l]=pre[r+1]-target的l
                if (index >= 0) {
                    // 找到精确匹配的值，此时子数组和恰好等于 target
                    ans = Math.min(ans, right - index + 1);
                } else {
                    int insertionPoint = -index - 1; //插入点
                    // 插入点左侧的元素都 <= requiredSum（因为数组递增）
                    // 取 insertionPoint - 1 作为可能的左边界，insertionPoint = 0 说明数组中所有元素都大于 requiredSum（即没有符合 pre[left] <= requiredSum 的左边界）
                    if (insertionPoint > 0) { // 确保有合法的左边界
                        ans = Math.min(ans, right - (insertionPoint - 1) + 1);
                    }
                }
            }
            return ans == n + 1 ? 0 : ans;
        }

        // 滑动窗口 NlogN
        // 循环内更新答案 每个可行解都更新答案
        public int minSubArrayLen1(int target, int[] nums) {
            int n = nums.length;
            int minStart = 0, minLen = n + 1;
            int sum = 0;
            int left = 0;
            for (int right = 0; right < n; ++right) {
                int x = nums[right];
                sum += x;
                while (sum >= target) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }
                    sum -= nums[left++];
                }
            }
            return minLen != n + 1 ? minLen : 0;
        }

        // 循环外更新答案
        public int minSubArrayLen2(int target, int[] nums) {
            int n = nums.length;
            int minStart = 0, minLen = n + 1;
            int sum = 0;
            int left = 0;
            for (int right = 0; right < n; ++right) {
                int x = nums[right];
                sum += x;
                while (sum - nums[left] >= target) {
                    sum -= nums[left++];
                }
                if (sum >= target && right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
            }
            return minLen != n + 1 ? minLen : 0;
        }
    }

    class Solution1 {
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