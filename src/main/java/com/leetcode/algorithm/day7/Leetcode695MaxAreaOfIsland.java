package com.leetcode.algorithm.day7;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @date 2023-03-06 12:55
 */
public class Leetcode695MaxAreaOfIsland {

    //方法一 深度优先搜索 递归
    public int maxAreaOfIsland1(int[][] grid) {
        if (grid == null || grid.length == 0 || (grid[0] == null || grid[0].length == 0)) { //二维数组判空
            return 0;
        }
        int ans = 0; //最大的岛屿面积
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        int ans = 1; //当前点是土地
        grid[x][y] = 0; //防止重复访问
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        for (int i = 0, nx = 0, ny = 0; i < 4; ++i) { //上下左右
            nx = x + dx[i];
            ny = y + dy[i];
            ans += dfs(grid, nx, ny); //
        }
        return ans;
    }

    //方法二：深度优先搜索 栈
    public int maxAreaOfIsland2(int[][] grid) {
        int ans = 0; //最大的岛屿面积
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; j++) { //[i][j]所连的土地
                int area = 0; //[i][j]未知，可能为0 or 1
                Deque<Integer> stacki = new LinkedList<>(); //i
                Deque<Integer> stackj = new ArrayDeque<>(); //j
                stacki.push(i);
                stackj.push(j);
                while (!stacki.isEmpty()) { //
                    int cur_i = stacki.poll();
                    int cur_j = stackj.poll();
                    if (cur_i < 0 || cur_j < 0 || cur_i >= grid.length || cur_j >= grid[0].length || grid[cur_i][cur_j] == 0) { //判断当前像素是否为土地
                        continue;
                    }
                    ++area; //当前点是土地
                    grid[cur_i][cur_j] = 0; //防止重复访问
                    int[] dx = {1, 0, 0, -1};
                    int[] dy = {0, 1, -1, 0};
                    for (int index = 0, next_i = 0, next_j = 0; index < 4; ++index) { //遍历上下左右
                        next_i = cur_i + dx[index];
                        next_j = cur_j + dy[index];
                        stacki.push(next_i);
                        stackj.push(next_j);
                    }
                }
                //当前片土地检查完了
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    //方法三：广度优先搜索 队列
    public int maxAreaOfIsland3(int[][] grid) {
        int ans = 0; //最大的岛屿面积
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; j++) { //[i][j]所连的土地
                int area = 0; //[i][j]未知，可能为0 or 1
                Queue<Integer> queuei = new ArrayDeque<>(); //i
                Queue<Integer> queuej = new ArrayDeque<>(); //j
                queuei.offer(i);
                queuej.offer(j);
                while (!queuei.isEmpty()) { //
                    int cur_i = queuei.poll();
                    int cur_j = queuej.poll();
                    if (cur_i < 0 || cur_j < 0 || cur_i >= grid.length || cur_j >= grid[0].length || grid[cur_i][cur_j] == 0) { //判断当前像素是否为土地
                        continue;
                    }
                    ++area; //当前点是土地
                    grid[cur_i][cur_j] = 0; //防止重复访问
                    int[] dx = {1, 0, 0, -1};
                    int[] dy = {0, 1, -1, 0};
                    for (int index = 0, next_i = 0, next_j = 0; index < 4; ++index) { //遍历上下左右
                        next_i = cur_i + dx[index];
                        next_j = cur_j + dy[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);
                    }
                }
                //当前片土地检查完了
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] grid = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(grid));
        Stack stack = new Stack(); //
        Queue<Integer> queue1 = new LinkedList<>();

        Queue<Integer> queue2 = new ArrayDeque<>();

        Deque<Integer> deque1 = new LinkedList<>();

        Deque<Integer> deque2 = new ArrayDeque<>();

    }
}
