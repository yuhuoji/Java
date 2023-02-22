package com.bilibili40.chapter01;

import org.junit.Test;

/* 选择排序 */
public class SelectionSort {
    public void selectionSort(int[] arr) {
        /* 判断 */
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) { //i 0~N-2
            /* 最小值下标 */
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { //j i+1~N-1
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                /* 交换 */
                swap(arr, i, minIndex);
            }
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* !!!swap可用XOR（^）操作来实现,不用中间变量 条件：a和b指向的内存是两块东西，即a！=b */
    private void swapPlus(int[] arr, int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    @Test
    public void selectionSortTest(){

    }
}

