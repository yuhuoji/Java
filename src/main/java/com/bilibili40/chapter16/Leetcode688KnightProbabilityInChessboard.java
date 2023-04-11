package com.bilibili40.chapter16;

/**
 * @date 2023-04-11
 */
public class Leetcode688KnightProbabilityInChessboard {
    /**
     * @param N    区域共N行
     * @param M    列
     * @param row  现在在row行
     * @param col  列
     * @param rest 总共走rest步
     * @return 返回生存点数
     */
    private int live(int N, int M, int row, int col, int rest) {
        if (row < 0 || row >= N || col < 0 || col >= M) { //越界
            return 0;
        }
        //没越界
        if (rest == 0) { //走完了
            return 1;
        }

        //上下左右四个位置
        return live(N, M, row + 1, col, rest - 1)
                + live(N, M, row - 1, col, rest - 1)
                + live(N, M, row, col - 1, rest - 1)
                + live(N, M, row, col + 1, rest - 1);
    }

    /**
     * 主函数
     */
    public String bob1(int N, int M, int i, int j, int k){
        long all = (long) Math.pow(4, k); //总共的方法数
        long live = live(N, M, i, j, k); //生存的方法数
        long gcd = gcd(all, live); //最大公约数
        return (live / gcd) + "/" + (all / gcd);
    }

    /**
     * 最大公约数
     * @param a a
     * @param b b
     * @return 最大公约数
     */
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
