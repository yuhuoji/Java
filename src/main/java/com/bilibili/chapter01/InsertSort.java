package com.bilibili.chapter01;

import org.junit.Test;

import java.util.Arrays;

/* 插入排序 */
public class InsertSort {
    public void insertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++) { //0~N-1依次插入做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
            /* */
//            for (int j = i - 1; j >= 0; j--) {
//                if (arr[j] > arr[j + 1]) {
//                    swap(arr, j, j + 1);
//                }
//            }

        }
    }
    /* 条件：i != j */
    private void swap(int[] arr, int i, int j) {
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }

    /* 对数器 for test */
    private void comparator(int[] arr){
        Arrays.sort(arr);
    }

/*    public void int[] generatoRandomArray(int maxSize, int maxValue){
        System.out.println();
        return ;
    }*/


    @Test
    public void test(){
        int[] arr = new int[]{6,2,7,9,3,5,6};
        System.out.println("arr = " + Arrays.toString(arr));
        this.insertSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("Hello world!");
    }
}

