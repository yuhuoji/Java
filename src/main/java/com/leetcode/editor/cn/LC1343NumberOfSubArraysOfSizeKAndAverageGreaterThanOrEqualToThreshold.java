package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 1343 大小为 K 且平均值大于等于阈值的子数组数目
public class LC1343NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "1343");
        Solution solution = new LC1343NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold().new Solution();

    }
    // average = sum/k > threshold
    // sum > threshold * k

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int n = arr.length;
            int sum = 0;
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                sum += arr[i];
                if (i < k - 1) {
                    continue;
                }
                ans += sum >= threshold * k ? 1 : 0;
                sum -= arr[i - k + 1];
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}