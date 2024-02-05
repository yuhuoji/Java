package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 334 Increasing Triplet Subsequence
public class LC334IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 334);
        Solution solution = new LC334IncreasingTripletSubsequence().new Solution();

    }
    // TODO @date 2023-12-25
    // 1.最长递增子序列 贪心

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int n = nums.length;
            int[] lMin = new int[n]; //[0..i]最小值
            int[] rMax = new int[n];
            lMin[0] = nums[0];
            for (int i = 1; i < n; ++i) {
                lMin[i] = Math.min(nums[i], lMin[i - 1]);
            }
            rMax[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                rMax[i] = Math.max(nums[i], rMax[i + 1]);
            }
            for (int i = 1; i < n - 1; ++i) {
                if (lMin[i] < nums[i] && nums[i] < rMax[i]) {
                    return true;
                }
            }
            return false;
        }

        public boolean increasingTriplet1(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (nums[j] <= nums[i]) {
                        continue;
                    }
                    for (int k = j + 1; k < n; ++k) {
                        if (nums[k] <= nums[j]) {
                            continue;
                        }
                        return true;
                    }
                }
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}