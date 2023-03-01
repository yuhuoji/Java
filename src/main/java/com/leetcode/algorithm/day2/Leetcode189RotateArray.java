package com.leetcode.algorithm.day2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2023-03-01 13:29
 * 双指针
 */
public class Leetcode189RotateArray {

    //拷贝(i + k) % n
    public void rotate1(int[] nums, int k) {
//        System.arraycopy();
//        Arrays.copyOf(); //浅拷贝
    }

    //方法三：数组翻转
    //先整体反转，再翻转两次
    public void rotate3(int[] nums, int k) {
        k %= nums.length; //k>nums.length
        //翻转三次
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    //原地翻转
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums));
        rotate3(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
