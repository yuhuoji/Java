package com.bilibili40.chapter16;

import org.junit.Test;

import java.util.Comparator;

/**
 * @date 2023-04-10
 * 跳马问题
 * 动态规划
 */
public class HouseJump {

    /**
     * 从(0,0)前往(x,y), 必须跳step步
     *
     * @param x    横坐标
     * @param y    纵坐标
     * @param step 需要跳的步数
     * @return 返回方法数
     */
    private static int process(int x, int y, int step) {
        if (x < 0 || x > 9 || y < 0 || y >= 9) { //越界
            return 0;
        }
        if (step == 0) { //要求跳0步到(0,0)
            return (x == 0 && y == 0) ? 1 : 0;
        }

        //(x,y)不越界且还有步数可以跳
        //有八个可能的位置
        //x - 2,y + 1
        //x - 1,y + 2
        //x + 1,y + 2
        //x + 2,y + 1
        //x + 2,y - 1
        //x + 1,y - 2
        //x - 1,y - 2
        //x - 2,y - 1
        return process(x - 2, y + 1, step - 1) +
                process(x - 1, y + 2, step - 1) +
                process(x + 1, y + 2, step - 1) +
                process(x + 2, y + 1, step - 1) +
                process(x + 2, y - 1, step - 1) +
                process(x + 1, y - 2, step - 1) +
                process(x - 1, y - 2, step - 1) +
                process(x - 2, y - 1, step - 1);
    }

    public int getWays(int x, int y, int k) {
        return process(x, y, k);
    }


    public int dpWays(int x, int y, int step) {
        if (x < 0 || x > 9 || y < 0 || y >= 9) {
            return 0;
        }
        int[][][] dp = new int[9][10][step + 1]; //x 0~8, y 0~9, step 0~step
        dp[0][0][0] = 1; //第一层其他位置为0
        for (int h = 1; h <= step; ++h) { //1~step层
            for (int row = 0; row < 9; ++row) { //0~8行
                for (int col = 0; col < 10; ++col) { //0~9列
                    dp[row][col][h] += getValue(dp, row - 2, col + 1, h - 1); //getValue方法用于防止越界
                    dp[row][col][h] += getValue(dp, row - 1, col + 2, h - 1);
                    dp[row][col][h] += getValue(dp, row + 1, col + 2, h - 1);
                    dp[row][col][h] += getValue(dp, row + 2, col + 1, h - 1);
                    dp[row][col][h] += getValue(dp, row + 2, col - 1, h - 1);
                    dp[row][col][h] += getValue(dp, row + 1, col - 2, h - 1);
                    dp[row][col][h] += getValue(dp, row - 1, col - 2, h - 1);
                    dp[row][col][h] += getValue(dp, row - 2, col - 1, h - 1);
                }
            }
        }
        return dp[x][y][step];
    }

    /**
     * 防止越界
     *
     * @param dp   数组
     * @param x    横坐标 0~8
     * @param y    纵坐标 0~9
     * @param step 步数 0~step
     * @return 返回值，如果越界返回0
     */
    private int getValue(int[][][] dp, int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        return dp[x][y][step];
    }

    @Test
    public void test() {

    }

    //写一个比较器，用于验证动态规划算法
    public static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        }
    }

}
