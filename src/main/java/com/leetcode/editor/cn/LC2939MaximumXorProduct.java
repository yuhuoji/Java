package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2939 Maximum Xor Product
public class LC2939MaximumXorProduct {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2939);
        Solution solution = new LC2939MaximumXorProduct().new Solution();

    }

    // REVIEW @date 2023-11-25
    // 位运算O(1)
    // 假设a >= b
    // ax和bx中的1的个数一定，ax + bx 是定值，尽量接近时乘积最大
    // 异或
    // 均为0或均为1 -》 1
    // 一个是0一个是1 -》 高于n的位置a>b，则全分配给b；高于n的位置a==b，高位给a，其余给b
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int maximumXorProduct1(long a, long b, int n) {
            if (a < b) { // 交换a、b，保证a>=b
                long tmp = a;
                a = b;
                b = tmp;
            }
            long mask = (1L << n) - 1; // n-1...0共n个1
            long ax = a & ~mask; // 无法通过x修改的，0 <= x < 2^n，去掉高于等于n的位置
            long bx = b & ~mask;
            // 下面算能被x影响的位置
            a &= mask; // 保留低于n的位置
            b &= mask;

            long left = a ^ b; // 需要分配的位置，ab不同的位置
            long one = mask ^ left; // 无需分配的位置，ab相同的位置，异或结果必定为1
            ax |= one; // 或ax+=one，加入答案
            bx |= one;

            if (left > 0 && ax == bx) {
                long highBit = 1L << (63 - Long.numberOfLeadingZeros(left)); // 最高位的数
                ax |= highBit; // 最高位给a
                left ^= highBit; // 剩下的
            }

            // ax更大，全分给b
            bx |= left;

            final long MOD = 1_000_000_007;
            return (int) ((ax % MOD) * (bx % MOD) % MOD); // 直接乘溢出
        }

        // 贪心 O(N)
        // 看a XOR x 和 b XOR x哪个小就给谁
        public int maximumXorProduct(long a, long b, int n) {
            final long MOD = 1_000_000_007;
            long al = (a >> n) << n, bl = (b >> n) << n;
            for (int i = n - 1; i >= 0; --i) {
                // 看a XOR x 和 b XOR x哪个小就给谁
                long x = (a >> i) & 1;
                long y = (b >> i) & 1;
                // 相同则得1,不同则谁小谁得1
                if (x == y) {
                    al |= 1L << i;
                    bl |= 1L << i;
                } else if (al < bl) {
                    al |= 1L << i;
                } else {
                    bl |= 1L << i;
                }
            }
            return (int) ((al % MOD) * (bl % MOD) % MOD);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}