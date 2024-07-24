package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 461 汉明距离
public class LC461HammingDistance {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 461);
        Solution solution = new LC461HammingDistance().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int ans = 0;
            while (xor != 0) {
                ans += xor & 1;
                xor >>>= 1;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}