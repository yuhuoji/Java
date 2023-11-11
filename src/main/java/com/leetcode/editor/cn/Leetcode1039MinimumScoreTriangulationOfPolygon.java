package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1039 Minimum Score Triangulation of Polygon 区间dp
public class Leetcode1039MinimumScoreTriangulationOfPolygon {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1039);
        Solution solution = new Leetcode1039MinimumScoreTriangulationOfPolygon().new Solution();
        String s = "[1,3,1,4,1,5]";
        int[] values = LeetCodeHelper.stringToIntegerArray(s);
        System.out.println(solution.minScoreTriangulation(values));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] v;

        // f[i][j] = 枚举k min{f[i][k] + f[k][j] + v[i]*v[j]*v[k]} i<k<j
        // i 倒序枚举，j顺序枚举
        // 边界 f[i][i+1]=0 组不成三角形
        // 入口 f[0][n-1]
        public int minScoreTriangulation(int[] values) {
            int n = values.length;
            int[][] f = new int[n][n];
            for (int i = n - 3; i >= 0; --i) {
                for (int j = i + 2; j < n; ++j) {
                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; ++k) {
                        min = Math.min(min, f[i][k] + f[k][j] + values[i] * values[j] * values[k]);
                    }
                    f[i][j] = min;
                }
            }
            return f[0][n - 1];
        }

        // dfs(i,j)多边形i到j的最低分
        // dfs(i,j) = 枚举k min{dfs(i,k) + dfs(k,j) + v[i]*v[j]*v[k]} i<k<j
        // 边界 dfs(i,i+1)=0 组不成三角形
        // 入口 dfs(0,n-1)
        // 递归TLE 状态N^2 每个计算时间N 时间O(N^3) 空间O(N^2)
        public int minScoreTriangulation1(int[] values) {
            int n = values.length;
            this.v = values;
            return dfs(0, n - 1);
        }

        private int dfs(int i, int j) {
            if (i + 1 == j) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; ++k) {
                min = Math.min(min, dfs(i, k) + dfs(k, j) + v[i] * v[j] * v[k]);
            }
            return min;
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

}