package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 790 Domino and Tromino Tiling
public class LC790DominoAndTrominoTiling {

    public static void main(String[] args) {
        System.out.println("Leetcode " + 790);
        Solution solution = new LC790DominoAndTrominoTiling().new Solution();
        int n = 5;
        System.out.println(solution.numTilings(n));
    }

    // f(n) = 2*f(n-1) + f(n-3) n>=4
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numTilings(int n) {
            if (n == 1) {
                return 1;
            }
            long MOD = (long) (1e9 + 7);
            long[] f = new long[n + 1];
            f[0] = f[1] = 1;
            f[2] = 2;
            for (int i = 3; i <= n; ++i) {
                f[i] = (2 * f[i - 1] + f[i - 3]) % MOD;
            }
            return (int) f[n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}