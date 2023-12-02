package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 260 Single Number III
public class LC260SingleNumberIii {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 260);
        Solution solution = new LC260SingleNumberIii().new Solution();

    }

    // 位运算 转换成136
    // 根据xor中不同的1分组
    // 如lowbit = s&(-s)
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            int xor = 0;
            for (int x : nums) {
                xor ^= x;
            }
            int tz = Integer.numberOfTrailingZeros(xor); // 尾0的个数
            int[] ans = new int[2];
            for (int x : nums) {
                ans[x >>> tz & 1] ^= x;
            }
            return ans;
        }

        public int[] singleNumber1(int[] nums) {
            int xor = 0;
            for (int x : nums) {
                xor ^= x;
            }
            int lowbit = xor & (-xor); // 取得lowbit
            int[] ans = new int[2];
            for (int x : nums) {
                // 分组异或，&lowbit==0的一组（lowbit上为0），其他一组（lowbit上为1）
                ans[(x & lowbit) == 0 ? 0 : 1] ^= x;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}