package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2090 半径为 k 的子数组平均值
public class LC2090KRadiusSubarrayAverages {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "2090");
        Solution solution = new LC2090KRadiusSubarrayAverages().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getAverages(int[] nums, int k) {
            int n = nums.length;
            if (n < 2 * k + 1) {
                return new int[]{-1};
            }
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            long sum = 0;
            for (int i = 0; i < n; ++i) {
                sum += nums[i];
                if (i - k < 0 || i + k >= n) {
                    continue;
                }
                ans[i] = (int) (sum / (2 * k + 1));
                sum -= nums[i - k + 1];
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}