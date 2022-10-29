package com.arithmeticBiliBili.chapter02;

import com.sun.org.apache.bcel.internal.generic.LLOAD;
import org.junit.Test;

/* 归并排序
* T(N) = 2*T(N/2) + O（N）
* log(2,2) = 1 时间复杂度NlogN
*
*
* */
public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int L, int R) {
        /* arr只有一个属 */
        if (L == R)
            return;
        int mid = L + ((R - L) >> 1); //中点
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R); //合并
    }

    /* 合并两个有序数组 */
    private void merge(int[] arr, int L, int M, int R) {
        int[] tempArr = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            tempArr[i++] = arr[L] <= arr[R] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            tempArr[i++] = arr[p1++];
        }
        while (p2 <= R) {
            tempArr[i++] = arr[p2++];
        }
        /* 复制 */
        for (i = 0; i < tempArr.length; i++) {
            arr[L + i] = tempArr[i];
        }
    }

    @Test
    public void mergeSortTest() {
        int[] arr = {6,2,8,3,9,4,0,1};
        System.out.println("mergeSortTest");
    }
}
