package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 363 矩形区域不超过 K 的最大数值和
public class LC363MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 363);
        Solution solution = new LC363MaxSumOfRectangleNoLargerThanK().new Solution();

    }
    // REVIEW @date 2024-08-09 二维前缀和+抽象一维
    // lc560 一维 + 枚举上下边界

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // sum[r]-sum[l-1]<=k
        // 找最小的sum[l-1]，满足 sum[r]-k<=sum[l-1]
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
            int ans = Integer.MIN_VALUE;
            for (int top = 1; top <= m; ++top) {
                for (int bottom = top; bottom <= m; ++bottom) { // 枚举上下边界
                    TreeSet<Integer> ts = new TreeSet<>();
                    ts.add(0); //!
                    for (int right = 1; right <= n; ++right) { // 枚举右边界
                        int sumRight = sum[bottom][right] - sum[top - 1][right];
                        Integer sumLeft = ts.ceiling(sumRight - k);
                        if (sumLeft != null) {
                            int curSum = sumRight - sumLeft;
                            ans = Math.max(ans, curSum);
                        }
                        ts.add(sumRight);
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}