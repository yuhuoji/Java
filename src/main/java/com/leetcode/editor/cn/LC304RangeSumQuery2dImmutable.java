package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 304 二维区域和检索 - 矩阵不可变
public class LC304RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 304);
        String s = "[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]";
        int[][] matrix = LeetCodeHelper.stringTo2DIntegerArray(s);
        System.out.println(Arrays.deepToString(matrix));
        NumMatrix numMatrix = new LC304RangeSumQuery2dImmutable().new NumMatrix(matrix);
        // var matrix2 = LeetCodeHelper.stringTo2DIntArray("[[509227044,637282201],[759706,926411389],[3212316,9],[1000000000,1000000000],[297996899,1000000000],[572469597,1000000000],[134431215,1000000000],[3849770,1000000000],[740964597,4096],[1000000000,1000000000],[687608329,4096],[339477185,626514388],[235661081,1000000000],[1000000000,1000000000],[969657177,1051],[1000000000,1000000000],[1000000000,1000000000],[706847,1000000000],[3085345,710403333],[345073691,1000000000]]");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {

        public NumMatrix(int[][] matrix) {

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return 0;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// leetcode submit region end(Prohibit modification and deletion)

}