package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 70 爬楼梯
public class LC70ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 70);
        Solution solution = new LC70ClimbingStairs().new Solution();

    }

    //TODO @date 2024-07-18 lc70和lc518的关系
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 到达i的方法数f[i]=f[i-1]+f[i-2]
        // 初始值 f[-2]=0 f[-1]=0 f[0]=1 f[1]=1
        // 返回 f[n]
        // f[i+2]=f[i+1]+f[i]
        public int climbStairs(int n) {
            int[] f = new int[n + 1];
            f[0] = f[1] = 1;
            for (int i = 2; i <= n; ++i) {
                f[i] = f[i - 1] + f[i - 2];
            }
            return f[n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}