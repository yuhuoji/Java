package com.bilibili40.chapter02;

import org.junit.Test;

import java.util.Arrays;

/* 求arr[L...R]上的最大值 */
/* master公式 递归行为，子问题等规模得到过程可以用master过程求解时间复杂度
* T（N） = a*T(N/b) + O(N^d)
* 时间复杂度比较log（b,a）和d
* 谁大取谁，相等相乘 */
public class GetMax {
    public int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private int process(int[] arr, int L, int R) {
        /* arr只有一个属 */
        if (L == R)
            return arr[L];
        int mid = L + ((R - L) >> 1); //中点
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    @Test
    public void getMaxTest() {
        int[] arr = new int[]{6, 2, 8, 3, 5, 9, 7, 1, 0, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println("The max value in the array is " + this.getMax(arr));
    }
}
