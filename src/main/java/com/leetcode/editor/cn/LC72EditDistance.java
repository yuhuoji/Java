package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 72 编辑距离
public class LC72EditDistance {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 72);
        Solution solution = new LC72EditDistance().new Solution();

    }

    // REVIEW @date 2024-07-05
    // f[i][j] 的编辑距离
    // s1[i] = s2[j] f[i][j] = f[i-1][j-1]
    // != 删除 增加（删除第二个） 替换
    // f[i][j] = min{f[i-1][j]，f[i][j-1]，f[i-1][j-1]} + 1
    // 初始化
    // f[0][j] = n
    // f[i][0] = m
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            char[] s = word1.toCharArray();
            char[] t = word2.toCharArray();
            int m = word1.length();
            int n = word2.length();
            int[][] f = new int[m + 1][n + 1];
            for (int i = 0; i <= m; ++i) {
                f[i][0] = i;
            }
            for (int j = 0; j <= n; ++j) {
                f[0][j] = j;
            }
            f[0][0]=0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (s[i] == t[j]) {
                        f[i + 1][j + 1] = f[i][j];
                    } else {
                        f[i + 1][j + 1] = Math.min(f[i][j + 1], Math.min(f[i + 1][j], f[i][j])) + 1;
                    }
                }
            }
            return f[m][n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}