package com.bilibili40.chapter03;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/* 用小根堆排序一个几乎有序的数组（每一个数移动最多不超过k步 ）*/
public class SortedArrayDistanceLessK {
    public void sortedArrayDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //默认的小根堆 优先级队列
        /* 防止k过大；k=4与arr.length=5情况相同 */
        int index = 0;
        for (; index < Math.min(k+1, arr.length); index++) {
            heap.add(arr[index]);
        }
        /* 向k大的小根堆里增加一个数，再弹出（最小的）一个数 */
        int i = 0;
        for (; index< arr.length; index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
            System.out.println("arr = " + Arrays.toString(arr));
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }

    }

    @Test
    public void sortedArrayDistanceLessKTest() {
        int[] arr = {7,6,5,4,3,2,1};
        this.sortedArrayDistanceLessK(arr, 10);
        System.out.println("arr = " + Arrays.toString(arr));

    }
}
