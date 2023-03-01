package com.leetcode.algorithm.day1;

import org.junit.Test;

/**
 * @date 2023-02-28 20:00
 */
public class Leetcode35SearchInsertPosition {
    //[]
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        int middle = 0;
        while (left <= right) { //[]会出现left==right，只有一个元素
            middle = ((right - left) >> 1) + left;
            if (target <= nums[middle]) { //左侧
                ans = middle;
                right = middle - 1;
            } else { //右侧
                left = middle + 1;
            }
        }
        return ans;
    }

    //left<right
    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        if (target < nums[0]) {
            return 0;
        } else if (target > nums[n- 1]) {
            return n;
        }
        int left = 0, right = n - 1;
        int middle = 0;
        while (left < right) { //left==right退出
            middle = ((right - left) >> 1) + left;
            if (target <= nums[middle]) { //左侧
                right = middle - 1;
            } else { //右侧
                left = middle + 1;
            }
        }
        //left==right
        return target <= nums[left] ? left : left + 1;
//        if (target < nums[left]) {
//            return left;
//        } else if (target > nums[left]) {
//            return left+1;
//        } else {
//            return left;
//        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert1(nums, target));
    }
}
