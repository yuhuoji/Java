package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 1143 最长公共子序列
public class LC1143LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1143);
        Solution solution = new LC1143LongestCommonSubsequence().new Solution();

    }

    // REVIEW @date 2024-07-05 二维dp
    // 定义 f[i][j] 0..i-1 0..j-1
    // 递推
    // t1[i] = t2[j] 相等 f[i+1][j+1] = f[i][j] + 1
    // 不等 f[i+1][j+1] = max{f[i][j+1], f[i+1][j]}
    // 初始化
    // f[0][0] = 0
    // f[i][0] = 0 0..i-1 0..0
    // f[0][j] = 0 0..0 0..j-1
    // 返回f[m][n] 0..m-1 0..n-1
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 压缩成一个数组，额外存储被更新的位置
        public int longestCommonSubsequence(String string1, String string2) {
            char[] s1 = string1.toCharArray();
            char[] s2 = string2.toCharArray();
            int m = string1.length();
            int n = string2.length();
            int[] f = new int[n + 1];
            Arrays.fill(f, 0);
            int left, cur; //存储左下方，下方
            for (int i = 0; i < m; ++i) {
                left = 0;
                for (int j = 0; j < n; ++j) {
                    cur = f[j + 1];
                    if (s1[i] == s2[j]) {
                        f[j + 1] = left + 1;
                    } else {
                        f[j + 1] = Math.max(f[j + 1], f[j]);
                    }
                    left = cur;
                }
            }
            return f[n];
        }

        public int longestCommonSubsequence1(String string1, String string2) {
            char[] s1 = string1.toCharArray();
            char[] s2 = string2.toCharArray();
            int m = string1.length();
            int n = string2.length();
            int[][] f = new int[m + 1][n + 1];
            for (int i = 0; i <= m; ++i) {
                f[i][0] = 0;
            }
            for (int j = 0; j <= n; ++j) {
                f[0][j] = 0;
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (s1[i] == s2[j]) {
                        f[i + 1][j + 1] = f[i][j] + 1;
                    } else {
                        f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                    }
                }
            }
            return f[m][n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}