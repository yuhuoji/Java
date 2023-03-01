package com.leetcode.algorithm.day2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2023-03-01 11:42
 * day2双指针
 */
public class Leetcode977SquaresOfASortedArray {
    public int[] sortedSquares1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = (int) Math.pow(nums[i], 2);
        }
        //排序
        Arrays.sort(res);
        return res;
    }

    //双指针，归并
    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int negative = -1; //-1是可能的值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) { //负数，i++
                negative = i;
            } else { //第一个非负
                break;
            }
        }
        //0~negative negative~n-1
        int[] ans = new int[n];
        int index = 0, p1 = negative, p2 = negative + 1;
        /*
        while (p1 >= 0 && p2 < n) {
            if (-nums[p1] <= nums[p2]) {
                ans[index] = nums[p1] * nums[p1];
                p1--;
            } else if (-nums[p1] > nums[p2]) {
                ans[index] = nums[p2] * nums[p2];
                p2++;
            }
            index++;
        }
        //边界
        while (p1 >= 0) {
            ans[index++] = nums[p1] * nums[p1];
            p1--;
        }
        while (p2 < n) {
            ans[index++] = nums[p2] * nums[p2];
            p2++;
        }
        */
        while (p1 >= 0 || p2 < n) {
            //先检查边界情况，防止越界
            if (p1 < 0) {
                ans[index] = nums[p2] * nums[p2];
                ++p2;
            } else if (p2 == n) {
                ans[index] = nums[p1] * nums[p1];
                --p1;
            } else if (nums[p1] * nums[p1] < nums[p2] * nums[p2]) { //负数p1小
                ans[index] = nums[p1] * nums[p1];
                --p1;
            } else { //正数p2大
                ans[index] = nums[p2] * nums[p2];
                ++p2;
            }
            ++index;
        }

        return ans;
    }

    //双指针，从大到小，可以不用考虑边界
    public int[] sortedSquares3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //n-1~0
        for (int i = 0, j = n - 1, index = n - 1; i <= j; ) {
            if (nums[i] * nums[i] <= nums[j] * nums[j]) {
                ans[index] = nums[j] * nums[j];
            } else {
                ans[index] = nums[i] * nums[i];
            }
            index--;
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares2(nums)));
    }
}
