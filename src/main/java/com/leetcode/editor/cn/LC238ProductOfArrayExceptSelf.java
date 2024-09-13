package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 238 除自身以外数组的乘积
public class LC238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 238);
        Solution solution = new LC238ProductOfArrayExceptSelf().new Solution();

    }

    // 前后缀
    // ans[i]=pre[i]*suf[i]
    // pre[i] 0..i-1的乘积 pre前面插入一位1
    // pre[i]=pre[i-1]*nums[i-1] 0..i-1 的乘积
    // pre[0]=1
    // suf[i]=suf[i+1]*nums[i+1]

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] suf = new int[n]; // 后缀
            suf[n - 1] = 1;
            for (int i = n - 2; i >= 0; --i) {
                suf[i] = suf[i + 1] * nums[i + 1];
            }
            int pre = 1; // 前缀
            for (int i = 0; i < n; ++i) {
                suf[i] *= pre;
                pre *= nums[i];
            }
            return suf;
        }

        // 前后缀两个数组
        public int[] productExceptSelf1(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n];
            int[] suf = new int[n];
            int[] ans = new int[n];
            pre[0] = 1;
            for (int i = 1; i < n; ++i) {
                pre[i] = pre[i - 1] * nums[i - 1];
            }
            suf[n - 1] = 1;
            for (int i = n - 2; i >= 0; --i) {
                suf[i] = suf[i + 1] * nums[i + 1];
            }
            for (int i = 0; i < n; ++i) {
                ans[i] = pre[i] * suf[i];
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}