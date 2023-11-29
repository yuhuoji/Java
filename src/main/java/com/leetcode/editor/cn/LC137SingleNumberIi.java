package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 137 Single Number II
public class LC137SingleNumberIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 137);
        Solution solution = new LC137SingleNumberIi().new Solution();

    }

    // REVIEW @date 2023-11-29 位运算 有限状态自动机
    // 1.哈希表统计
    // 有限状态自动机，每一个二进制位对3取余 00 -> 01 -> 10 -> 00 ..
    // 当前状态 two one，输入 二进制位 n
    // 以上是对数字的二进制中 “一位” 的分析，而 int 类型的其他 31 位具有相同的运算规则，因此可将以上公式直接套用在 32 位数上。（按位）
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // a b同时计算
        public int singleNumber(int[] nums) {
            int a = 0, b = 0;
            for (int x : nums) {
                int tmpA = a;
                a = (a ^ x) & (a | b);
                b = (b ^ x) & ~tmpA;
            }
            return b;
        }

        // 两位bit1, bit0
        // 先计算b
        public int singleNumber1(int[] nums) {
            int bit0 = 0, bit1 = 0;
            for (int num : nums) {
                bit0 = bit0 ^ num & ~bit1;
                bit1 = bit1 ^ num & ~bit0;
            }
            return bit0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}