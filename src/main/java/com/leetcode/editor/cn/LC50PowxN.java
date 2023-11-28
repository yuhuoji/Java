package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 50 Pow(x, n)
public class LC50PowxN {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 50);
        Solution solution = new LC50PowxN().new Solution();
        double x = 2.1;
        int n = 3;
        System.out.println(solution.myPow(x, n));
    }

    //-2^31 <= n <= 2^31-1
    // 模拟 TLE
    // 快速幂 O(log n)
    // 递归
    // REVIEW @date 2023-11-27 迭代
    // 幂n二进制展开
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            }
            long N = n; // Integer.MIN_VALUE
            // x!=0
            return N >= 0 ? quickMul(x, N) : quickMul(1.0 / x, -N);
        }

        // 迭代
        // 幂n二进制展开 9 = 1001b
        // x^9 = x^(2^3+0+0+2^0) 从低位向高位计算
        private double quickMul(double x, long n) {
            double ans = 1;
            while (n > 0) {
                if ((n & 1) == 1) { // 计入答案
                    ans *= x;
                }
                x *= x;
                n >>= 1;
            }
            return ans;
        }

        // 递归
        private double quickMul1(double x, long n) {
            if (n == 0) {
                return 1;
            }
            double ans = quickMul(x, n / 2);
            return n % 2 == 0 ? ans * ans : ans * ans * x;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}