package com.bilibili40.chapter11;

import org.junit.Test;

/**
 * @date 2023-03-18
 * 数出岛的数量
 */
public class IslandClass {
    /**
     * 计算岛屿的数量，改成2
     * 时间复杂度O(N*M)
     *
     * @param grid 数组
     * @return 数量
     */
    public int countIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) { //二维数组判空, null {} {{}}
            return 0;
        }
        int row = grid.length, column = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) { //N*M
                if (grid[i][j] == 1) { //为岛屿
                    ++count;
                    infect(grid, i, j, row, column);
                }
            }
        }
        return count;
    }

    /**
     * 把当前相连的岛屿1改成2
     * 时间复杂度O（N*M） 4*N*M
     *
     * @param grid   数组
     * @param i      当前位置
     * @param j      当前位置
     * @param row    数组行
     * @param column 数组列
     */
    private void infect(int[][] grid, int i, int j, int row, int column) {
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2; //将岛屿改成2
        //上下左右四个方向
        infect(grid, i - 1, j, row, column);
        infect(grid, i + 1, j, row, column);
        infect(grid, i, j - 1, row, column);
        infect(grid, i, j + 1, row, column);
    }


    @Test
    public void test() {

    }
}
