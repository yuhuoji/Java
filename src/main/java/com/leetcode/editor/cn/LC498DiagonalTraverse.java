package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 498 对角线遍历
public class LC498DiagonalTraverse {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "498");
        Solution solution = new LC498DiagonalTraverse().new Solution();
        String s = "[[1,2,3],[4,5,6],[7,8,9]]";
        System.out.println(solution.findDiagonalOrder(LeetCodeHelper.stringTo2DIntegerArray(s)));
    }

    // 对角线遍历
    // 斜着编号k=i+j
    // 偶数从左下到右上，小于m时起点为(k,0)，大于等于m时(m-1,k-m+1)
    // 奇数从右上到左下, 小于n时(0,k)，大于等于n时(k-n+1,n-1)
    //
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int idx = 0;
            int[] ans = new int[m * n];
            for (int k = 0; k <= m + n - 2; ++k) {
                if (k % 2 == 0) {
                    int x = k < m ? k : m - 1;
                    int y = k < m ? 0 : k - m + 1;
                    while (x >= 0 && y < n) {
                        ans[idx++] = mat[x--][y++];
                    }
                } else {
                    int x = k < n ? 0 : k - n + 1;
                    int y = k < n ? k : n - 1;
                    while (x < m && y >= 0) {
                        ans[idx++] = mat[x++][y--];
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}