package com.bilibili40.chapter08;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @date 2022-11-26 22:05
 */
public class IPO {
    /**
     * 输入:正数数组costs正数数组profits
     * 正数k正数m
     * 含义:costs [i]表示i号项目的花费
     * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
     * 说明:你每做完一个项目,马上获得的收益,可以支持你去做下一个项目。
     *
     * @param k       表示你只能串行的最多做k个项目
     * @param W       表示你初始的资金
     * @param profits 利润
     * @param capital 花费
     * @return 你最后获得的最大钱数。
     */
    public int findMaximizedCapital(int k, int W, int[] profits, int[] capital) {
        PriorityQueue<Node> minCostPriorityQueue = new PriorityQueue<>(new MinCostComparator()); // 按花费的小根堆
        PriorityQueue<Node> maxProfitPriorityQueue = new PriorityQueue<>(new MaxProfitComparator()); // 按利润的大根堆
        // 所有项目项目加入小根堆，只有资金大于花费才会弹出
        for (int i = 0; i < profits.length; i++) {
            maxProfitPriorityQueue.add(new Node(profits[i], capital[i]));
        }
        for (int i = 0; i < k; i++) { // 进行k轮
            // 能启动的项目都已经解锁了
            while (!minCostPriorityQueue.isEmpty() && minCostPriorityQueue.peek().cost <= W) { // 还有可以投资的项目且
                maxProfitPriorityQueue.add(minCostPriorityQueue.poll());
            }
            if (minCostPriorityQueue.isEmpty()) { // 所有项目都检查完了，终止
                return W;
            }
            W += maxProfitPriorityQueue.poll().profit; // 贪心：选择当前满足资金的最大利润的项目 => 总体最优
        }
        return W;
    }

    static class Node {
        public int cost;
        public int profit;

        public Node() {
        }

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    // 小根堆
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    // 大根堆
    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.cost - o1.cost;
        }
    }

}
