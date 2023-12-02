package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 190 Reverse Bits
public class LC190ReverseBits {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 190);
        Solution solution = new LC190ReverseBits().new Solution();

    }

    // REVIEW @date 2023-12-01 位运算
    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value
        private static final int M1 = 0x55555555; // 01010101010101010101010101010101 取奇偶位
        private static final int M2 = 0x33333333; // 00110011001100110011001100110011 两位
        private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111 四位
        private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111 八位

        // 用&取出，移动到对应位置，用|加上
        public int reverseBits(int n) {
            n = n >>> 1 & M1 | (n & M1) << 1; // 偶数位 | 奇数位 交换
            n = n >>> 2 & M2 | (n & M2) << 2; // 间隔2位交换
            n = n >>> 4 & M4 | (n & M4) << 4; // 间隔4位交换
            n = n >>> 8 & M8 | (n & M8) << 8; // 间隔8位交换
            return n >>> 16 | n << 16; // 间隔16位交换
        }

        public int reverseBits1(int n) {
            int ans = 0;
            for (int i = 0; i < 32 && n != 0; n >>>= 1, ++i) {
                ans |= (n & 1) << (31 - i); // 取n最低位
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}