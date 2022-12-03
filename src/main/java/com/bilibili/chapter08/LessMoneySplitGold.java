package com.bilibili.chapter08;

import java.util.PriorityQueue;

/**
 * @date 2022-11-26 16:16
 * 一块金条切成两半,是需要花费和长度数值一样的铜板的。比如长度为20的金条,不管切成长度多大的两半,都要花费20个铜板。一群人想整分整块金条,怎么分最省铜板?
 * 例如,给定数组[10,20,30),代表一共三个人,整块金条长度为10+20+30=60。金条要分成10,20,30三个部分。
 * 如果先把长度60的金条分成10和50,花费60;再把长度50的金条分成20和30,花费50;一共花费110铜板。
 * 但是如果先把长度60的金条分成30和30,花费60;再把长度30金条分成10和20,花费30;一共花费90铜板。
 * 输入一个数组,返回分割的最小代价。
 * huffman编码
 */
public class LessMoneySplitGold {
    public int lessMoney(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); //PriorityQueue默认是小根堆，大根堆小重写compare方法(v1, v2) -> v2 - v1
        for (int item : arr) {
            priorityQueue.add(item);
        }
        int sum = 0; //花费的总金额
        int cur = 0; //当前的节点
        while (priorityQueue.size() > 1) { //只剩一个节点时结束
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);
        }
        return sum;
    }
}
