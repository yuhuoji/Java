package com.leetcode.algorithm.day7;

import org.junit.Test;

import java.util.*;

/**
 * @date 2023-03-06 11:41
 * 广度优先搜索 / 深度优先搜索
 */
public class Leetcode733FloodFill {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    //bfs
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc]; //old -> new
        if (oldColor == color) {
            return image;
        }
        Pixel start = new Pixel(sr, sc); //起点
        Queue<Pixel> queue = new LinkedList<>();
        int xlength = image.length;
        int ylength = image[0].length;
        int[][] visited = new int[xlength][ylength]; //访问数组
        image[sr][sc] = color;
        queue.offer(start);
        visited[sr][sc] = 1;
        while (!queue.isEmpty()) {
            Pixel cur = queue.poll();
            for (int i = 0, x = 0, y = 0; i < 4; ++i) { //上下左右
                x = cur.sr + dx[i];
                y = cur.sc + dy[i];
                if (x >= 0 && y >= 0 && x < xlength && y < ylength && image[x][y] == oldColor) { //operation
                    image[x][y] = color;
                    queue.offer(new Pixel(x, y));
                    visited[x][y] = 1; //set visited
                }
            }
        }
        return image;
    }

    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc]; //old -> new
        if (oldColor != color) {
            dfs(image, sr, sc, oldColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (image[x][y] == oldColor) {
            image[x][y] = newColor;
            for (int i = 0, nx = 0, ny = 0; i < 4; ++i) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < image.length && ny < image[0].length) {
                    dfs(image, nx, ny, oldColor, newColor);
                }
            }
        }
    }

    @Test
    public void test() {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(image));
        System.out.println(Arrays.deepToString(floodFillDFS(image, 1, 1, 2)));

    }

    public class Pixel {
        int sr;
        int sc;

        public Pixel(int sr, int sc) {
            this.sr = sr;
            this.sc = sc;
        }
    }
}
