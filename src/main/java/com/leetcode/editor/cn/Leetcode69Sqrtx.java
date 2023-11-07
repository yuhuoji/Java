package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 69 Sqrt(x)
public class Leetcode69Sqrtx {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 69);
        Solution solution = new Leetcode69Sqrtx().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // x*x>=x
        // 找不大于平方根的最大数
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }
            // x>=2
            int l = 1, r = x; //[1,x)
            while (l < r) {
                // 循环不变量：
                // nums[l-1] <= target
                // nums[r] > target
                int m = ((r - l) >> 1) + l;
                if (m > x / m) {
                    r = m; //[l,m)
                } else {
                    l = m + 1; //[m,r)
                }
            }
            // l==r
            return l - 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}