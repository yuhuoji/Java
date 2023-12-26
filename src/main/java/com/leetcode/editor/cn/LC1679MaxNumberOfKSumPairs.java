package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 1679 Max Number of K-Sum Pairs
public class LC1679MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1679);
        Solution solution = new LC1679MaxNumberOfKSumPairs().new Solution();

    }

    // 双指针
    // x k-x
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxOperations(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            int cnt = 0;
            for (int l = 0, r = n - 1; l < r; ) {
                int sum = nums[l] + nums[r];
                if (sum == k) {
                    cnt++;
                    l++;
                    r--;
                } else if (sum < k) {
                    l++;
                } else {
                    r--;
                }
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}