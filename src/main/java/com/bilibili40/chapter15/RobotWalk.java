package com.bilibili40.chapter15;

/**
 * @date 2023-04-09
 *
 * ***
 * 递归 ->
 * -> 记忆化搜索（加缓存） ->
 * -> 严格表结构
 * (
 * 1.确定可变参数，几维表。
 * 2.确定终止位置。
 * 3.确定base case直接出答案。
 * 4.确定除23外，其他普通位置是如何依赖的。
 * 5.根据234确定计算顺序(从叶节点向上计算)，具体计算方法同递归
 * )
 *
 * 动态规划
 */
public class RobotWalk {

    /**
     * 递归
     * N、E是固定参数，与状态无关
     * cur、rest是可变参数，与当前状态相关，决定返回值
     * 时间复杂度 O(2^K)
     *
     * @param N    总共有1~N位置
     * @param E    机器人目标位置
     * @param cur  当前位置
     * @param rest 还剩几步
     * @return 返回可能的方法数
     */
    public static int f1(int N, int E, int cur, int rest) {
        if (rest == 0) { //结束
            return cur == E ? 1 : 0;
        }
        if (cur == 1) { //只能往右1 -> 2
            return f1(N, E, cur + 1, rest - 1);
        }
        if (cur == N) { //只能往左N-1 <- N
            return f1(N, E, cur - 1, rest - 1);
        }
        //其他位置
        return f1(N, E, cur + 1, rest - 1) + f1(N, E, cur - 1, rest - 1);
    }

    /**
     * 记忆化搜索
     * 递归改记忆化搜索：用表记录所有可能的结果，返回前把结果记录一下，每次递归前检查是否命中
     * 调用递归函数 <=> 从表中取值
     * 加一个记录表，缓存已经计算过的递归结果
     * 只是加一个缓存，不去整理位置之间的依赖关系
     * 时间复杂度 O(K*N)
     *
     * @param N    总共有1~N位置
     * @param E    机器人目标位置
     * @param cur  当前位置
     * @param rest 还剩几步
     * @return 返回可能的方法数
     */
    public static int f2(int N, int E, int cur, int rest, int[][] dp) {
        if (dp[rest][cur] != -1) { //缓存命中
            return dp[rest][cur];
        }

        //缓存没命中 rest>0
        if (rest == 0) { //结束
            dp[rest][cur] = cur == E ? 1 : 0;
        } else if (cur == 1) { //只能往右1 -> 2
            dp[rest][cur] = f2(N, E, cur + 1, rest - 1, dp);
        } else if (cur == N) { //只能往左N-1 <- N
            dp[rest][cur] = f2(N, E, cur - 1, rest - 1, dp);
        } else { //其他位置
            dp[rest][cur] = f2(N, E, cur + 1, rest - 1, dp) + f2(N, E, cur - 1, rest - 1, dp);
        }

        return dp[rest][cur];
    }

    /**
     * 严格表结构的动态规划
     * 处理位置依赖的顺序
     */

    /**
     * 问题：请你求出机器人从S起始位置走K步到达终止位置E，一共有多少种走法？注意，每次机器人必须走一步，不能留在原地，每次只能走一格，可以向右或者向左。1位置只能往右，N位置只能往左。
     *
     * @param N 总共有1~N位置
     * @param E 机器人目标位置
     * @param S 机器人起始位置
     * @param K 机器人必须一共走K步
     * @return 返回可能的方法数
     */
    public int walkWays1(int N, int E, int S, int K) {
        return f1(N, E, S, K);
    }

    public int walkWays2(int N, int E, int S, int K) {
        int[][] dp = new int[K + 1][N + 1]; //缓存表
        for (int i = 0; i < K; ++i) {
            for (int j = 0; j < N; ++j) {
                dp[i][j] = -1; //-1代表未记录过
            }
        }
        return f2(N, E, S, K, dp);
    }
}
