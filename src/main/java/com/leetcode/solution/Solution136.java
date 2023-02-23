package com.leetcode.solution;

import org.junit.Test;

/**
 * @date 2023-02-23 16:27
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int ans =0;
        for (int num:nums) {
            ans ^= num;
        }
        return ans;
    }
    @Test
    public void test(){

    }
}
