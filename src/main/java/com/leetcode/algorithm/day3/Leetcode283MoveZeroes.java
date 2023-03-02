package com.leetcode.algorithm.day3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2023-03-02 10:48
 */
public class Leetcode283MoveZeroes {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 0, 0, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //暴力
    public void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) { //000000 11111
        int slow = 0, fast = 0; //slow找第一个0 fast找第一个不是0的数
        while (fast < nums.length) {
            while (slow < nums.length && nums[slow] != 0) {
                slow++;
            }
            //slow找到0
            fast = slow + 1;
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }
            //fast找到非0的数
            //交换slow和fast
            if (slow < nums.length && fast < nums.length && slow < fast) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
            }

        }
    }

    //zero和i之间是0
    //两次遍历
    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int zero = 0; //不是0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { //非0的往前压缩
                nums[zero] = nums[i];
                zero++;
            }
        }
        while (zero < nums.length) {
            nums[zero++] = 0;
        }
    }

    //一次遍历
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}