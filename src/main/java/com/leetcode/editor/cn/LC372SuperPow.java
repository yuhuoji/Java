package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 372 Super Pow
public class LC372SuperPow {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 372);
        Solution solution = new LC372SuperPow().new Solution();
        int a = 2147483647;
        int[] b = {2, 0, 0};
        System.out.println(solution.superPow(a, b));
        StrictMath.pow(2222, 10);
    }

    // REVIEW @date 2023-11-28 快速幂 防止Math.pow的浮点误差
    // 快速幂
    // 10进制,从高位向低位计算
    // a^b =
    // b为奇数 a^b = a * a^(b-1)
    // b为偶数 a^b = ( a^(b/2) )^2
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = 1337;

        public int superPow(int a, int[] b) {
            return superPow(a, b, b.length - 1);
        }

        //[0..index]
        private int superPow(long a, int[] b, int index) {
            if (index == 0) {
                return pow((int) a, b[0]) % MOD;
            }
            long ans = superPow(a, b, index - 1);
            return (pow((int) ans, 10) % MOD) * (pow((int) a, b[index])) % MOD;
        }

        // 快速幂
        private int pow(int x, int n) {
            if (n == 0) {
                return 1;
            }
            int half = pow(x, n / 2) % MOD;
            return n % 2 == 0 ? (int) ((long) half * half % MOD) : (int) ((long) half * half % MOD * x % MOD);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}