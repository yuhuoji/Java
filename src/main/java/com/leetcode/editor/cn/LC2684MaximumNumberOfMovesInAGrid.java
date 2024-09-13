package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 2684 矩阵中移动的最大次数
public class LC2684MaximumNumberOfMovesInAGrid {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2684);
        Solution solution = new LC2684MaximumNumberOfMovesInAGrid().new Solution();
        String s = "[[1000000,92910,1021,1022,1023,1024,1025,1026,1027,1028,1029,1030,1031,1032,1033,1034,1035,1036,1037,1038,1039,1040,1041,1042,1043,1044,1045,1046,1047,1048,1049,1050,1051,1052,1053,1054,1055,1056,1057,1058,1059,1060,1061,1062,1063,1064,1065,1066,1067,1068],[1069,1070,1071,1072,1073,1074,1075,1076,1077,1078,1079,1080,1081,1082,1083,1084,1085,1086,1087,1088,1089,1090,1091,1092,1093,1094,1095,1096,1097,1098,1099,1100,1101,1102,1103,1104,1105,1106,1107,1108,1109,1110,1111,1112,1113,1114,1115,1116,1117,1118]]";
        System.out.println(solution.maxMoves(LeetCodeHelper.stringTo2DIntegerArray(s)));
    }

    // TODO @date 2024-07-16
    // lc931
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 每一步只能严格向右
        // f[r][c]表示到达当前位置走的步数
        // f[r][c]=c, if g[r][c]>x, where x=max(g[r-1][c-1],g[r][c-1],g[r+1][c-1]) 且x已到达
        // 边界f[r][0]=0 f[-1][c]=f[n][c]=不合规
        // 返回max(f)
        public int maxMoves(int[][] g) {
            int m = g.length;
            int n = g[0].length;
            int[][] f = new int[m][n];
            int ans = 0;
            for (int c = 1; c < n; ++c) {
                for (int r = 0; r < m; ++r) {
                    int x = g[r][c];
                    for (int i = -1; i <= 1; ++i) { // 遍历 g[r-1][c-1],g[r][c-1],g[r+1][c-1]
                        if (r + i >= 0 && r + i < m && f[r + i][c - 1] == c - 1 && g[r + i][c - 1] < x) {
                            f[r][c] = c;
                        }
                    }
                    ans = Math.max(ans, f[r][c]);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}