package com.leetcode.algorithm.day9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 2023-03-13 10:39
 * 广度优先搜索 / 深度优先搜索
 * TODO
 */
public class Leetcode54201Matrix {
    //方法一：广度优先搜索
    //从0开始多源广度优先搜索，所有0做超级源点
    public int[][] updateMatrix1(int[][] mat) {
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int[][] dist = new int[mat.length][mat[0].length]; //0到1的距离
        boolean[][] seen = new boolean[mat.length][mat[0].length]; //防止重复遍历
        Queue<int[]> queue = new LinkedList<>(); //保存所有的0，Queue存储二维数组
        //超级源点
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j}); //将0加入队列
                    seen[i][j] = true;
                }
            }
        }
        //广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int k = 0; k < 4; ++k) {
                int ni = i + direction[k][0], nj = j + direction[k][1];
                if (ni >= 0 && nj >= 0 && ni < mat.length && nj < mat[0].length && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1; //状态转移方程
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }

        }
        return dist;
    }

    //
    public int[][] updateMatrix2(int[][] mat){
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int[][] dist = new int[mat.length][mat[0].length]; //0到1的距离
        boolean[][] seen = new boolean[mat.length][mat[0].length]; //防止重复遍历
        Queue<int[]> queue = new LinkedList<>(); //保存所有的0，Queue存储二维数组

        return dist;
    }

    @Test
    public void test() {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(updateMatrix1(mat)));
    }
}
