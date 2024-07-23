package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 130 被围绕的区域
public class LC130SurroundedRegions {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 130);
        Solution solution = new LC130SurroundedRegions().new Solution();
        String s = "[[\"O\",\"O\",\"O\",\"O\",\"X\",\"X\"],[\"O\",\"O\",\"O\",\"O\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"O\",\"O\",\"O\"]]";
        char[][] cs = LeetCodeHelper.stringTo2DCharArray(s);
        solution.solve(cs);
        System.out.println(Arrays.deepToString(cs));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 并查集 分为两类
        // 1.内部连通
        // 2.边缘连通，与mn相连
        private int[] father;
        private final int[][] dir = new int[][]{{0, 1},  {1, 0}}; //, {0, -1},{-1, 0}
        private int MAXN;

        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            MAXN = m * n;
            this.father = new int[m * n + 1]; // fa[mn]作为哨兵节点，标记边缘连通的节点
            for (int i = 0; i <= m * n; ++i) {
                father[i] = i;
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] == 'O') {
                        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                            union(i * n + j, m * n); // 与m*n连通标记
                        } else {
                            for (var d : dir) { // 枚举四个方向
                                int ni = i + d[0], nj = j + d[1];
                                if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] == 'O') {
                                    union(i * n + j, ni * n + nj);
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (find(i * n + j) != find(m * n)) {
                        board[i][j] = 'X';
                    }
                }
            }
            System.out.println(Arrays.toString(father));
        }

        private int find(int i) {
            if (father[i] != i) {
                father[i] = find(father[i]);
            }
            return father[i];
        }

        private boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }

        // x连y
        private void union(int i, int j) {
            int fi = find(i);
            int fj = find(j);
            // if (fi != fj) {
            //     if (fi == MAXN) {
            //         father[fj] = fi;
            //     } else {
                    father[fi] = fj; // fi挂fj
                // }
            // }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}