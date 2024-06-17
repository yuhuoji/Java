package com.leetcode.algorithm.day4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @date 2023-03-03 10:43
 */
public class Leetcode344ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            ++left;
            --right;
        }
    }

    @Test
    public void test() {
        char[] chars = {'e', 'h', 'l', 'l', 'o'};
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
