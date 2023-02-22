package com.bilibili40.chapter06;

import org.junit.Test;

/**
 * @date 2022-11-01 21:28
 * 微软原题 纸条，对折n次，从上至下输出折痕
 */
public class PaperFolding {
    public void printAllFolds(int n) {
        printAllFoldsProcess(1, n, true);
    }

    //down true 凹, down false 凸
    private void printAllFoldsProcess(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        //左凹右凸
        printAllFoldsProcess(i + 1, n, true);
        System.out.print(down ? "凹" : "凸");
        printAllFoldsProcess(i + 1, n, false);

    }

    @Test
    public void test() {
        System.out.println("test");
        printAllFolds(5);
    }
}
