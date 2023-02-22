package com.bilibili40.chapter09;

/**
 * @date 2022-12-04 15:32
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量。返回你能装下最多的价值是多少?
 * <p>
 * TODO leetcode 2279
 */
public class Knapsack {
    /**
     * @param weights       重量
     * @param values        价值
     * @param i             当前来到的位置
     * @param alreadyWeight 已经选择的重量
     * @param bag           不能超过的最大重量
     * @return 最大重量
     */
    private int process1(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
        //base case
        if (alreadyWeight > bag) { //当前选择超重 => 错误
            return Integer.MIN_VALUE;
        }
        if (i == weights.length) { //结束
            return 0;
        }
        //选i和不选i取最大值
        return Math.max(
                process1(weights, values, i + 1, alreadyWeight, bag),
                weights[i] + process1(weights, values, i + 1, weights[i] + alreadyWeight, bag)
        );
    }

    private int process2(int[] weights, int[] values, int i, int alreadyWeight, int alreadyValue, int bag) {
        //base case
        if (alreadyWeight > bag) { //当前选择超重 => 错误
            return 0;
        }
        if (i == weights.length) { //结束
            return alreadyValue;
        }
        //选i和不选i取最大值
        return Math.max(
                process2(weights, values, i + 1, alreadyWeight, alreadyValue, bag),
                process2(weights, values, i + 1, weights[i] + alreadyWeight, values[i] + alreadyValue, bag)
        );
    }
}
