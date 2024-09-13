package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2320 统计放置房子的方式数
public class LC2320CountNumberOfWaysToPlaceHouses {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2320);
        Solution solution = new LC2320CountNumberOfWaysToPlaceHouses().new Solution();

    }

    // 排列组合(相乘)+一侧dp
    // f[i] 1..i
    // f[i]=f[i-2]+f[i-1]
    // f[-]=0
    // f[1]=2
    // f[2]=3
    // 返回 f[n]

    // f[0]=1
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = (int) (1e9 + 7);

        public int countHousePlacements2(int n) {
            if (n == 1) {
                return 4;
            } else if (n == 2) {
                return 9;
            }
            int f0 = 2;
            int f1 = 3;
            for (int i = 3; i <= n; ++i) {
                int newF = (int) (((long) f0 + f1) % MOD);
                f0 = f1;
                f1 = newF;
            }
            return (int) (((long) f1 * f1) % MOD);
        }

        public int countHousePlacements(int n) {
            int[] f = new int[n + 3];
            f[0] = 1;
            f[1] = 2;
            for (int i = 2; i <= n; ++i) {
                f[i] = (int) (((long) f[i - 2] + f[i - 1]) % MOD);
            }
            return (int) (((long) f[n] * f[n]) % MOD);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}