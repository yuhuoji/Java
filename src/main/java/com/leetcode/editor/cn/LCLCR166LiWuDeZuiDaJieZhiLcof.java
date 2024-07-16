package com.leetcode.editor.cn;

// LCR 166 珠宝的最高价值
public class LCLCR166LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "LCR 166");
        Solution solution = new LCLCR166LiWuDeZuiDaJieZhiLcof().new Solution();

    }

    // f[i][j]=max(f[i-1][j],f[i][j-1]) + frame[i][j]
    // 初始值f[0][j] f[i][0]
    // 返回f[m-1][n-1]
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jewelleryValue(int[][] frame) {
            int m = frame.length;
            int n = frame[0].length;
            int[] f = new int[n];
            f[0] = frame[0][0];
            for (int j = 1; j < n; ++j) {
                f[j] = f[j - 1] + frame[0][j]; // 第一行
            }
            for (int i = 1; i < m; ++i) {
                f[0] += frame[i][0]; // 每行最左侧的位置
                for (int j = 1; j < n; ++j) {
                    f[j] = Math.max(f[j], f[j - 1]) + frame[i][j];
                }
            }
            return f[n - 1];
        }

        public int jewelleryValue1(int[][] frame) {
            int m = frame.length;
            int n = frame[0].length;
            int[][] f = new int[m][n];
            f[0][0] = frame[0][0];
            for (int i = 1; i < m; ++i) {
                f[i][0] = f[i - 1][0] + frame[i][0];
            }
            for (int j = 1; j < n; ++j) {
                f[0][j] = f[0][j - 1] + frame[0][j];
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + frame[i][j];
                }
            }
            return f[m - 1][n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}