package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 1186 删除一次得到子数组最大和
public class LC1186MaximumSubarraySumWithOneDeletion {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1186);
        Solution solution = new LC1186MaximumSubarraySumWithOneDeletion().new Solution();

    }

    // REVIEW @date 2024-07-16
    // 参考lc53
    // f[i][0]=max(f[i-1][0],0)+x
    // f[i][1]=max(f[i-1][0],f[i-1][1]+x)
    // 边界f[-][j]=-inf
    // 返回max(f[i][j])
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] arr) {
            int n = arr.length;
            // f[0]之前计算的,f[1]正在计算的
            int[][] f = new int[2][2];
            Arrays.fill(f[0], Integer.MIN_VALUE / 2);
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                int x = arr[i];
                f[1][0] = Math.max(f[0][0], 0) + x;
                f[1][1] = Math.max(f[0][0], f[0][1] + x);
                ans = Math.max(ans, Math.max(f[1][0], f[1][1]));
                var tmp = f[0];
                f[0] = f[1];
                f[1] = tmp;
            }
            return ans;
        }

        public int maximumSum1(int[] arr) {
            int n = arr.length;
            int[][] f = new int[n + 1][2];
            Arrays.fill(f[0], Integer.MIN_VALUE / 2);
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                int x = arr[i];
                f[i + 1][0] = Math.max(f[i][0], 0) + x;
                f[i + 1][1] = Math.max(f[i][0], f[i][1] + x);
                ans = Math.max(ans, Math.max(f[i + 1][0], f[i + 1][1]));
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}