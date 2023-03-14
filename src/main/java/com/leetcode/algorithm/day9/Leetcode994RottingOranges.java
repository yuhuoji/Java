package com.leetcode.algorithm.day9;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

/**
 * @date 2023-03-14 21:27
 * 多源广度优先搜索
 */
public class Leetcode994RottingOranges {
    //方法一：多源广度优先搜索
    public int orangesRotting(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>(); //腐烂橘子
        HashMap<Integer, Integer> depth = new HashMap<>(); //橘子腐烂所需时间
        //找到所有腐烂的橘子
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < column; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * column + c; //将二维数组grid化为一维存储，
                    queue.offer(code); //腐烂橘子的位置
                    depth.put(code, 0); //超级源点为-1.开局腐烂的橘子为0
                }
            }
        }

        int ans = 0; //返回最长的路径
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        while (!queue.isEmpty()) { //遍历所有腐烂的橘子
            int code = queue.poll(); //当前腐烂橘子的位置
            int r = code / column, c = code % column; //将一维数组再转化成二维数组 [r][c]
            for (int k = 0; k < 4; ++k) { //遍历上下左右四个位置（下一次要腐烂的橘子）
                int nr = r + dr[k], nc = c + dc[k];
                if (0 <= nr && nr < row && 0 <= nc && nc < column && grid[nr][nc] == 1) { //是新鲜的橘子
                    grid[nr][nc] = 2;
                    int ncode = nr * column + nc; //该位置的一维坐标
                    queue.offer(ncode);
                    depth.put(ncode, depth.get(code) + 1); //腐烂时间为中心+1
                    ans = depth.get(ncode); //记录最后一次腐烂的橘子所需要的时间
                }
            }
        }

        //检查是否有橘子不能腐烂
        for (int[] rowArray : grid) {
            for (int element : rowArray) {
                if (element == 1) {
                    return -1; //最后仍有橘子不能腐烂，返回-1
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {

    }
}
