package com.bilibili40.chapter15;

import org.junit.Test;

/**
 * @date 2023-04-09
 * leetcode322 硬币数量infinite
 */
public class Leetcode322CoinChange {
    public int coinChange(int[] coins, int amount) {
        return process(coins, 0, amount);
    }

    /**
     * 选择和不选择当前硬币
     *
     * @param arr   所有的硬币
     * @param index 从arr[index...]选择硬币
     * @param rest  剩余的还需组成的面额
     * @return 返回使用硬币的数量
     */
    private int process(int[] arr, int index, int rest) {
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
        int ans1 = process(arr, index + 1, rest); //不选择当前硬币
        int ans2Next = process(arr, index + 1, rest - arr[index]); //选择当前硬币
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

    @Test
    public void test() {

    }
}
