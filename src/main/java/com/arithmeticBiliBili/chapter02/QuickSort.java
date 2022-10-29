package com.arithmeticBiliBili.chapter02;

import org.junit.Test;

/* 荷兰国旗问题partition */
/* 快速排序1.0 2.0 平均时间复杂度O() 最坏时间复杂度O(N^2)*/
/* 快速排序30 平均时间复杂度O(N*logN) 详细证明过程 概率论 无穷级数求和证明*/
public class QuickSort {
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        /* 数据量太小，选择插入排序 */
//        if (r-l<60){
//            //插入排序
//            return;
//        }

        swap(arr, l + (int) (Math.random() * (r - l + 1)), r); //快排3.0，随机快排

        int[] p = partition(arr, l, r); //分组，partition存分组的下标p[0], p[1]
        quickSort(arr, l, p[0]-1);
        quickSort(arr, p[0], r);
    }

    /* 分组 */
    private int[] partition(int[] arr, int l, int r){
        int[] res = {0, 1};
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void quickSortTest() {

    }
}
