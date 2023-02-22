package com.bilibili40.chapter09;

import org.junit.Test;

/**
 * @date 2022-12-03 23:11
 * chapter09 补充视频 暴力递归
 */
public class Hanoi {
    public void hanoi(int n) {
        if (n > 0) {
            func(n, "左", "右", "中");
        }
    }

    /**
     * hanoi实现函数，start -> end，
     *
     * @param i     移动1~i个圆盘
     * @param start 起点
     * @param end   终点
     * @param other 另一个杆是other
     */
    private void func(int i, String start, String end, String other) {
        if (i == 1) { //base case
            System.out.println("Move 1 from " + start + " to " + end);
        } else {
            func(i - 1, start, other, end); //i-1, start -> other
            System.out.println("Move " + i + " from " + start + " to " + end); //i, start -> end
            func(i - 1, other, end, start); //i-1, other -> end
        }
    }

    @Test
    public void test() {
        hanoi(7);
    }
}
