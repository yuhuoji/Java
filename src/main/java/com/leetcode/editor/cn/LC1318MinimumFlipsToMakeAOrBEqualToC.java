package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1318 Minimum Flips to Make a OR b Equal to c
public class LC1318MinimumFlipsToMakeAOrBEqualToC {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1318);
        Solution solution = new LC1318MinimumFlipsToMakeAOrBEqualToC().new Solution();

    }

    // 位运算 OR
    // 逐位计算
    // 10^9 有30位
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFlips(int a, int b, int c) {
            int ans = 0;
            for (int i = 0; i <= 31; ++i) {
                int aBit = (a >> i) & 1;
                int bBit = (b >> i) & 1;
                int cBit = (c >> i) & 1;
                if (cBit == 0) { // 必须都为0
                    ans += aBit + bBit;
                } else { // 至少一个为1
                    ans += aBit + bBit == 0 ? 1 : 0;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}