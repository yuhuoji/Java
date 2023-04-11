package com.bilibili40.chapter15;

import org.junit.Test;

/**
 * @date 2023-04-09
 * leetcode322 硬币数量infinite
 */
public class Leetcode322CoinChange {

    //生成随机长度为len，最大值为max的数组
    public static int[] generateRandomArray(int len, int max) {
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

    /**
     * 硬币数量都是一个
     */
    public int coinChange(int[] coins, int amount) {
        return process1(coins, 0, amount);
    }

    /**
     * 选择和不选择当前硬币
     *
     * @param arr   所有的硬币，每个硬币只有一个
     * @param index 从arr[index...]选择硬币
     * @param rest  剩余的还需组成的面额
     * @return 返回使用硬币的数量
     */
    private int process1(int[] arr, int index, int rest) {
        if (rest < 0) { //无法组成
            return -1;
        }
        if (rest == 0) { //剩余0，使用0枚硬币
            return 0;
        }
        //rest > 0
        if (index == arr.length) { //没有硬币可选了
            return -1;
        }
        //rest > 0 且还有硬币可以选择
        int ans1 = process1(arr, index + 1, rest); //不选择当前硬币
        int ans2Next = process1(arr, index + 1, rest - arr[index]); //选择当前硬币
        if (ans1 == -1 && ans2Next == -1) { //两种解法都无解，当前选择一定无解
            return -1;
        } else { //至少有一种解法
            if (ans1 == -1) { //不选择当前硬币无解
                return 1 + ans2Next;
            }
            if (ans2Next == -1) { //选择当前硬币无解
                return ans1;
            }
            return Math.min(ans1, 1 + ans2Next);//两种方法都有解，取使用硬币最少的解法
        }
    }

    /**
     * 硬币数量无限
     * 枚举行为 -> 动态规划
     */
    public int coinChange2(int[] coins, int aim) {
        return process2(coins, 0, aim);
    }

    /**
     * @param arr   硬币
     * @param index 可以用arr[index...]的硬币
     * @param rest  还需要组成的面额
     * @return 方法数
     */
    private int process2(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        //枚举行为
        for (int i = 0; arr[index] * i <= rest; ++i) { //硬币的个数i，当前金额arr[index] * i不大于需要的金额，就尝试
            ways += process2(arr, index + 1, rest - arr[index] * i);
        }
        return ways;
    }

    /**
     * 改动态规划
     * 时间复杂度O(N*aim) * 枚举行为O(aim)
     */
    public int dpCoinChange2(int[] coins, int aim) {
        if (coins == null || coins.length == 0 || aim < 0) {
            return 0;
        }
        //index 0~arr.length,aim 0~aim
        int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1]; //dp表
        dp[N][0] = 1; //最后一行，第N行，只有一种方法，就是不选任何硬币
        for (int index = N - 1; index >= 0; --index) { //从N-1行开始填到0行
            for (int rest = 0; rest <= aim; ++rest) { //从0列开始填到aim列
                //递归改从dp表中取值
                int ways = 0;
                for (int i = 0; coins[index] * i <= rest; ++i) { //硬币的个数i，当前金额arr[index] * i不大于需要的金额，就尝试
                    ways += dp[index + 1][rest - coins[index] * i]; //递归改成从dp表中取值
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    /**
     * 优化枚举行为
     * 把枚举行为用斜率优化，用邻近的值来代替
     * 时间复杂度O(N * aim)
     */
    public int dpCoinChange3(int[] coins, int aim) {
        if (coins == null || coins.length == 0 || aim < 0) {
            return 0;
        }
        //index 0~arr.length,aim 0~aim
        int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1]; //dp表
        dp[N][0] = 1; //最后一行，第N行，只有一种方法，就是不选任何硬币
        for (int index = N - 1; index >= 0; --index) { //从N-1行开始填到0行
            for (int rest = 0; rest <= aim; ++rest) { //从0列开始填到aim列

                dp[index][rest] =dp[index + 1][rest]; //一定有的一种选择：不选当前硬币
                if (rest-coins[index]>=0){
                    dp[index][rest] += dp[index][rest-coins[index]]; //加上选择当前硬币的方法数
                }

            }
        }
        return dp[0][aim];
    }

    @Test
    public void test() {
        int len = 10;
        int max = 10;
        int testTime = 1000;
        for (int i = 0; i < testTime; ++i) {
            int[] arr = generateRandomArray(len, max);
            int aim = (int) (Math.random() * 3 * max) + 1; //目标
            int ans1 = coinChange(arr, aim);
            int ans2 = coinChange2(arr, aim);
            if (ans1 != ans2) {
                System.out.println("Oops!");
            }
        }
    }
}
