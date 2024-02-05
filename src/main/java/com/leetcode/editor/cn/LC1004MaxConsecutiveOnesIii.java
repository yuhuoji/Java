package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1004 Max Consecutive Ones III
public class LC1004MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1004);
        Solution solution = new LC1004MaxConsecutiveOnesIii().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int cnt0 = 0;
        int mx = 0;
        for (int l = 0, r = 0; r < n; ++r) {
            cnt0 += nums[r] ^ 1;
            while (cnt0 > k) {
                cnt0 -= nums[l] ^ 1;
                l++;
            }
            mx = Math.max(mx, r - l + 1);
        }
        return mx;
    }
}
// leetcode submit region end(Prohibit modification and deletion)

}