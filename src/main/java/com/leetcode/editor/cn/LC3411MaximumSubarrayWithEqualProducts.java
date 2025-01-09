package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 3411 最长乘积等价子数组
public class LC3411MaximumSubarrayWithEqualProducts {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "3411");
        Solution solution = new LC3411MaximumSubarrayWithEqualProducts().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxLength(int[] nums) {
            int maxG = Arrays.stream(nums).max().getAsInt(); // 最大的gcd
            int allLcm = 1;
            for (int x : nums) {
                allLcm = lcm(allLcm, x);
            }
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                int m = 1;
                int g = 0;
                int l = 1;
                for (int j = i; j < nums.length; ++j) {
                    int x = nums[j];
                    m *= x;
                    g = gcd(g, x);
                    l = lcm(l, x);
                    if (m == g * l) {
                        ans = Math.max(ans, j - i + 1);
                    }
                    if (m > allLcm * maxG) { // m增大，g可能减小，之后不可能相等
                        break;
                    }
                }
            }
            return ans;
        }

        // 最大公因数（Greatest Common Divisor，简称 GCD）模版
        private int gcd(int a, int b) {
            int remainder = a % b;
            while (remainder != 0) {
                a = b;
                b = remainder;
                remainder = a % b;
            }
            return b;
        }

        private int lcm(int a, int b) {
            return a / gcd(a, b) * b;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}