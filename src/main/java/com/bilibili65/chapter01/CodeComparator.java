package com.bilibili65.chapter01;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2023-02-23 09:29
 */
public class CodeComparator {
    public int[] arrWithRandomLengthAndRandomValue(int maxLength, int maxValue) {
        int len = (int) (Math.random() * maxLength);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    //ascending order
    public boolean isSorted(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (max > j) {
                return false;
            }
            max = Math.max(max, j);
        }
        return true;
    }

    //descending order
    public boolean isDescendingOrder(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (min < j) {
                return false;
            }
            min = Math.min(min, j);
        }
        return true;
    }

    @Test
    public void test() {
        int[] arr = new int[]{9, 6, 4, 2, 5};
        System.out.println(isSorted(arr));
        System.out.println(isDescendingOrder(arr));
        System.out.println(Arrays.toString(copyArray(arr)));
        System.out.println(Arrays.toString(arrWithRandomLengthAndRandomValue(10,50)));
    }
}
