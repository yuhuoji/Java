package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 120 三角形最小路径和
public class LC120Triangle {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 120);
        Solution solution = new LC120Triangle().new Solution();

    }

    // 自顶向下或自底向上
    // 自底向上
    // f[i][j] = min(f[i+1][j],f[i+1][j+1])+triangle[i][j]
    // 返回[0][0]
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] f = new int[n];
            for (int j = 0; j < n; ++j) { // 最后一行
                f[j] = triangle.get(n - 1).get(j);
            }
            for (int i = n - 2; i >= 0; --i) { // 自底向上，从n-2行开始
                for (int j = 0; j <= i; ++j) { // i行有i+1个格
                    f[j] = Math.min(f[j], f[j + 1]) + triangle.get(i).get(j);
                }
            }
            return f[0];
        }

        public int minimumTotal1(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] f = new int[n][n];
            for (int j = 0; j < n; ++j) { // 最后一行
                f[n - 1][j] = triangle.get(n - 1).get(j);
            }
            for (int i = n - 2; i >= 0; --i) { // 自底向上，从n-2行开始
                for (int j = 0; j <= i; ++j) { // i行有i+1个格
                    f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
            return f[0][0];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}