package com.leetcode.solution;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @date 2023-03-04 14:14
 * 剑指 Offer II 041. 滑动窗口的平均值
 * 使用队列模拟滑动窗口
 */
public class LeetcodeSwordPointOfferII041AverageSlidingWindow {
    @Test
    public void test() {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // 返回 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // 返回 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // 返回 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // 返回 6.0 = (10 + 3 + 5) / 3

    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
    class MovingAverage {
        Queue<Integer> queue;
        int size;
        double sum;

        public MovingAverage(int size) {
            queue = new ArrayDeque<Integer>(); //用ArrayDeque不用LinkedList，底层实现分别是数组和链表
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            if (queue.size() == size) { //判断窗口是否已满
                sum -= queue.poll();
            }
            //增加整数
            queue.offer(val);
            sum += val;
            return sum / queue.size(); //返回平均值
        }
    }

}
