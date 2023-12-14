package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 338 Counting Bits
public class LC338CountingBits {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 338);
        Solution solution = new LC338CountingBits().new Solution();

    }

    // 位运算
    // 奇数 = 前一个偶数(=偶数/2) + 1
    // 偶数 = 偶数/2，最低位为0
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                ans[i] = ans[i >> 1] + (i & 1);
            }
            return ans;
        }

        public int[] countBits1(int n) {
            int[] ans = new int[n + 1];
            ans[0] = 0;
            for (int i = 1; i <= n; ++i) {
                if (i % 2 == 1) { // 奇数
                    ans[i] = ans[i - 1] + 1;
                } else { // 偶数
                    ans[i] = ans[i / 2];
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}