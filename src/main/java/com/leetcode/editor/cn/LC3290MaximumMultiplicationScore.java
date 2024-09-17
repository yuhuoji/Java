package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 3290 Maximum Multiplication Score
public class LC3290MaximumMultiplicationScore {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "3290");
        Solution solution = new LC3290MaximumMultiplicationScore().new Solution();

    }
    // 子序列 dp
    // 定义dfs(i,j)表示从b[0..i]中选j+1个数，和a[0,,j]做点积的最大值
    // dfs(i,j)=max(dfs(i-1,j),dfs(i-1,j-1)+a[j]*b[i])

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxScore(int[] a, int[] b) {
            int n = b.length;
            long[][] f = new long[n + 1][5];
            Arrays.fill(f[0], 1, 5, Long.MIN_VALUE / 2);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < 4; ++j) {
                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i][j] + (long) a[j] * b[i]);
                }
            }
            return f[n][4];
        }

        // dfs(i,j)=max(dfs(i-1,j),dfs(i-1,j-1)+a[j]*b[i])
        // f[i][j]=max(f[i-1][j],f[i-1][j-1]+a[j]*b[i])
        // i和j前面插入一个 f[i+1][j+1]=max(f[i][j+1],f[i][j]+a[j]*b[i])
        // 边界
        // f[][0]=0
        // f[0][]=-inf f[0][0]=0
        // 返回
        // dfs(n - 1, 3);
        // f[n][4]
    }

    class Solution1 {
        private int[] a, b;

        public long maxScore(int[] a, int[] b) {
            int n = b.length;
            this.a = a;
            this.b = b;
            return dfs(n - 1, 3);
        }

        // dfs(i,j)=max(dfs(i-1,j),dfs(i-1,j-1)+a[j]*b[i])
        private long dfs(int i, int j) {
            if (j < 0) { // a都匹配完了
                return 0;
            }
            if (i < 0) { // j>=0 不合法
                return Integer.MIN_VALUE / 2;
            }
            return Math.max(dfs(i - 1, j), dfs(i - 1, j - 1) + a[j] * b[i]);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}