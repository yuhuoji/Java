package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1493 Longest Subarray of 1's After Deleting One Element
public class LC1493LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1493);
        Solution solution = new LC1493LongestSubarrayOf1sAfterDeletingOneElement().new Solution();

    }

    // 删除一个元素，只包含1的最长长度
    // 只包含1个0 删掉0 ：1101
    // 不包含0 删掉边上一个 ：111
    // 求最多包含一个0的最长长度-1
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {
            int n = nums.length;
            int cnt0 = 0;
            int mx = 0;
            for (int l = 0, r = 0; r < n; ++r) {
                cnt0 += nums[r] ^ 1;
                while (cnt0 > 1) {
                    cnt0 -= nums[l] ^ 1;
                    l++;
                }
                mx = Math.max(mx, r - l + 1);
            }
            return mx - 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}