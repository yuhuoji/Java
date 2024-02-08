package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 3030 Find the Grid of Region Average
public class LC3030FindTheGridOfRegionAverage {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 3030);
        Solution solution = new LC3030FindTheGridOfRegionAverage().new Solution();

    }

    // REVIEW @date 2024-02-08
    // 平均值
    // 平均值的平均值 先累加，统计在在几个区域内，最后计算
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] resultGrid(int[][] a, int threshold) {
            int m = a.length;
            int n = a[0].length;
            int[][] res = new int[m][n];
            int[][] cnt = new int[m][n];
            for (int i = 2; i < m; ++i) {
                next:
                for (int j = 2; j < n; ++j) {
                    // 左右相邻差值
                    for (int x = i - 2; x <= i; ++x) {
                        if (Math.abs(a[x][j - 2] - a[x][j - 1]) > threshold || Math.abs(a[x][j - 1] - a[x][j]) > threshold) {
                            continue next; // 跳出循环
                        }
                    }
                    // 上下相邻差值
                    for (int y = j - 2; y <= j; ++y) {
                        if (Math.abs(a[i - 2][y] - a[i - 1][y]) > threshold || Math.abs(a[i - 1][y] - a[i][y]) > threshold) {
                            continue next;
                        }
                    }
                    // 计算3x3平均值
                    int avg = 0;
                    for (int x = i - 2; x <= i; ++x) {
                        for (int y = j - 2; y <= j; ++y) {
                            avg += a[x][y];
                        }
                    }
                    avg /= 9;
                    // 更新3x3结果
                    for (int x = i - 2; x <= i; ++x) {
                        for (int y = j - 2; y <= j; ++y) {
                            res[x][y] += avg;
                            cnt[x][y]++; // 统计在几个3x3区域内
                        }
                    }

                }
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (cnt[i][j] == 0) { // 不属于任何3x3
                        res[i][j] = a[i][j];
                    } else {
                        res[i][j] /= cnt[i][j];
                    }
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}