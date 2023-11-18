package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 201 Bitwise AND of Numbers Range
public class LC201BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 201);
        Solution solution = new LC201BitwiseAndOfNumbersRange().new Solution();
        int left = 9, right = 12;
        System.out.println(Integer.toBinaryString(left));
        System.out.println(Integer.toBinaryString(right));
        // 1001
        // 1100
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 位运算 []
        // l 和 r 位数不同则结果一定为0
        // 求二进制下的最长公共前缀

        // Brian Kernighan 算法」，它用于清除二进制串中最右边的 1
        public int rangeBitwiseAnd(int left, int right) {
            while (left < right) {
                right &= (right - 1);
            }
            return right;
        }

        public int rangeBitwiseAnd2(int left, int right) {
            int shift = 0;
            while (left < right) {
                left >>= 1;
                right >>= 1;
                shift++;
            }
            return left << shift;
        }

        // TLE
        public int rangeBitwiseAnd1(int left, int right) {
            int ans = left;
            for (int i = left + 1; i <= right; ++i) {
                ans &= i;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}