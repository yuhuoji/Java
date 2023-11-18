package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 200 Number of Islands
public class LC200NumberOfIslands {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 200);
        Solution solution = new LC200NumberOfIslands().new Solution();

    }

    // 一维和二维下标变换
    // (i) <-> (i/n, i%n)
    // (i,j) <-> (i*n + j)
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] father; // 300*300
        int setsNumber;
        char[][] grid;

        int m;
        int n; // 每行的数量

        public int numIslands(char[][] grid) {
            this.grid = grid;
            m = grid.length;
            n = grid[0].length;
            build(m * n);
            // for (int i = 0; i < m; ++i) {
            //     for (int j = 0; j < n; ++j) {
            //         if (grid[i][j] == '1') {
            //             // 只查左上，右下包括在后序
            //             if (j > 0 && grid[i][j - 1] == '1') { // 左
            //                 union(i * n + j, i * n + j - 1);
            //             }
            //             if (i > 0 && grid[i - 1][j] == '1') { // 上
            //                 union(i * n + j, (i - 1) * n + j);
            //             }
            //         }
            //     }
            // }
            for (int i = 0, x = 0, y = 0; i < m * n; ++i) {
                x = i / n;
                y = i % n;
                if (grid[x][y] == '1') {
                    if (y > 0 && grid[x][y - 1] == '1') { // 左 (i - 1)
                        union(i, i - 1);
                    }
                    if (x > 0 && grid[x - 1][y] == '1') { // 上 (i - n)
                        union(i, i - n);
                    }
                }
            }
            return setsNumber;
        }

        // 每个1建一个集合，指向自己
        void build(int size) {
            father = new int[size];
            setsNumber = 0;
            for (int i = 0; i < size; ++i) { //(i) -> (i/n, i%n), i from 0 to size
                int x = i / n, y = i % n;
                if (grid[x][y] == '1') {
                    father[i] = i;
                    setsNumber++;
                }
            }
        }

        int find(int i) {
            if (i != father[i]) {
                father[i] = find(father[i]);
            }
            return father[i]; // 代表节点自己指向自己
        }

        boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                father[find(x)] = find(y);
                setsNumber--;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}