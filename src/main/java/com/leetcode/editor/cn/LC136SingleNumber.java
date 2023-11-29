package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 136 Single Number
public class LC136SingleNumber {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 136);
        Solution solution = new LC136SingleNumber().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // a^a = 0
        // a^a^b = b
        // 0^a = a
        public int singleNumber(int[] nums) {
            int x = 0;
            for (int num : nums) {
                x ^= num;
            }
            return x;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}