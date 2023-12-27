package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2943 Maximize Area of Square Hole in Grid
public class LC2943MaximizeAreaOfSquareHoleInGrid {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2943);
        Solution solution = new LC2943MaximizeAreaOfSquareHoleInGrid().new Solution();
        int n = 2;
        int m = 4;
        String h = "[3,2]";
        String v = "[4,2]";
        // Set<Integer> set = solution.getGap(LeetCodeHelper.stringToIntegerArray(v));
        // System.out.println(set);
        System.out.println(solution.maximizeSquareHoleArea(n, m, LeetCodeHelper.stringToIntegerArray(h), LeetCodeHelper.stringToIntegerArray(v)));
    }

    // 开始格子均为1*1 正方形中间不能有线
    // REVIEW @date 2023-12-27 分组循环
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
            int h = getMaxGap(hBars);
            int v = getMaxGap(vBars);
            int size = Math.min(h, v);
            return size * size;
        }

        // 分组循环 找最长的连续序号
        private int getMaxGap(int[] f) {
            Arrays.sort(f);
            int n = f.length;
            int max = 1, i = 0;
            while (i < n) {
                int start = i;
                for (i++; i < n && f[i] - f[i - 1] == 1; ++i) ;
                //[start, i-1]
                max = Math.max(max, i - start);
            }
            return max + 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}