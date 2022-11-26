package com.bilibili.chapter03;

import org.junit.Test;

import java.util.Arrays;

/* 堆（完全二叉树） N个数的堆层数有⌊log(N)⌋+1
 * 堆排序  大顶堆最大的数与最后一位交换，heapSize--，arr[0]做heapify； 时间复杂度O（N*log（N））空间复杂度O（1）
 * TODO 大根堆，小根堆
 * */
public class HeapSort {
    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

//        /* 全部排成大顶堆 O(N*log(N)) */
//        for (int i = 0; i < arr.length; i++) { //O(N)
//            heapInsert(arr, i); //O(log(N))
//        }
        /* TODO 全部排成大顶堆, 更快？ O() */
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;

        swap(arr, 0, --heapSize); //排好最大的数
        /* O(log(N*log(N))) */
        while (heapSize > 0) { //O(N)
            heapify(arr, 0, heapSize); //排成大顶堆 O(log(N))
            swap(arr, 0, --heapSize); //排好最大的数
        }
    }

    /* 某个数在index位置，判断能否向下上移动
     * 父节点（i-1）/2 */
    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2); //与父节点交换
            index = (index - 1) / 2; //向上移动
        }
    }

    /* 保证堆结构，某个数在index位置，判断能否向下移动, 左节点2*i+1, 右节点2*i+2
     * heapSize = 最后一个数的下标+1；
     * 时间复杂度O（log(N)）*/
    public void heapify(int[] arr, int index, int heapSize) {
        /* 左孩子2*i+1, 右孩子2*i+2 */
        int left = index * 2 + 1; //right = left + 1

//        int largest;
        while (left < heapSize) {
            /* 两个子节点比较 */
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1 : left;
/*            if ((left + 1 < heapSize) && (arr[left + 1] > arr[left])) {
                largest = left + 1;
            } else {
                largest = left;
            }*/

            /* 较大值与父节点比较 */
            largest = arr[index] >= arr[largest] ? index : largest;
/*            if (arr[index] >= arr[largest]) {
                largest = index;
            }*/

            /* 父节点最大，结束移动 */
            if (largest == index)
                break;
            swap(arr, largest, index);
            System.out.println("swap(arr, " + largest + ", " + index + ");");

            /* 准备下次循环 */
            index = largest; //下移到子节点
            left = 2 * index + 1;
        }
        System.out.println("Heapify over.");
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* TODO 打印堆结构 */
    public void heapPrint(int[] arr, int heapSize) {
        int layer = (int) (Math.log(heapSize) / Math.log(2)) + 1; //层数
        System.out.println("layer = " + layer);
        for (int i = 0, index = 0; i < layer; i++) { //行
            for (int j = 0; j < Math.pow(2, i) && index < heapSize; j++) { //列
                System.out.print(arr[index++] + "\t");
            }
            System.out.println();
        }
        System.out.println("Heap = " + Arrays.toString(arr));
    }

    @Test
    public void HeapSortTest() {
        int[] arr = new int[]{1, 6, 5, 4, 3, 2};
        int heapSize = 6; //数组模拟 0~heapSize-1
        heapify(arr, 0, heapSize);
        heapPrint(arr, heapSize);
    }
}
