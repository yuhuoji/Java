package com.leetcode.algorithm.day4;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2023-03-03 11:38
 */
public class Leetcode557ReverseWordsInAStringIII {
    //方法一：使用额外空间

    //方法二：原地解法 还是浪费空间 java String是不可更改类型
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int len = chars.length;
        int index = 0; // '\0'
        while (index < len) {
            //找到分割
            while ( chars[index] != ' ') {
                ++index;
                if (index>=len){
                    break;
                }
            }
            right = index - 1;

            //翻转单词,
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                ++left;
                --right;
            }

            left = index + 1;
            //go on
            ++index;
        }

        return new String((chars));
    }

    @Test
    public void test() {
        String s = "Let's take LeetCode contest";
        String reverseS = reverseWords(s);
        System.out.println(reverseS);
    }
}
