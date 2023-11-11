package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 367 Valid Perfect Square
public class LC367ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println("LC " + 367);
        Solution solution = new LC367ValidPerfectSquare().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 找到小于平方根的最大数k，看是否是平方根k*k=num
        public boolean isPerfectSquare(int num) {
            if (num == 1) {
                return true;
            }
            int l = 1, r = num;
            while (l <= r) {
                // 循环不变量：
                // nums[l-1]*nums[l-1] <= num
                // nums[r]*nums[r] > num
                int m = ((r - l) >> 1) + l;
                if (m > num / m) {
                    r = m - 1; //[l,m)
                } else {
                    l = m + 1; //[m,r)
                }
            }
            // l=r+1
            return r * r == num;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}