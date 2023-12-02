package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 191 Number of 1 Bits
public class LC191NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 191);
        Solution solution = new LC191NumberOf1Bits().new Solution();

    }

    // 汉明重量
    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        // n & (n - 1)
        public int hammingWeight(int n) {
            int cnt = 0;
            while (n != 0) {
                n &= (n - 1);
                cnt++;
            }
            return cnt;
        }

        public int hammingWeight1(int n) {
            int cnt = 0;
            for (int i = 0; i < 32; ++i) {
                cnt += n >>> i & 1;
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}