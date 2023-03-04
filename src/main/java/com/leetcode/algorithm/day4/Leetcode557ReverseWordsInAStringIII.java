package com.leetcode.algorithm.day4;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2023-03-03 11:38
 */
public class Leetcode557ReverseWordsInAStringIII {
    //方法一：使用额外空间StringBuffer类
    public String reverseWords1(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        int start = 0;
        int end = 0;
        while (end < length) {
//            start = end; //单词开始位置
            while (end < length && s.charAt(end) != ' ') { //end找到空格
                ++end;
            }
            //start到end-1依次翻转单词
            for (int i = end - 1; i >= start; --i) {
                stringBuffer.append(s.charAt(i));
            }
            if (end < length) {
                stringBuffer.append(s.charAt(end)); //追加空格
            }
            start = ++end;
        }
        //返回翻转后的字符串
        return stringBuffer.toString();
    }

    //方法二：原地解法 还是浪费空间 java String是不可更改类型
    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int len = chars.length;
        int index = 0; // '\0'
        while (index < len) {
            //找到分割
            while (chars[index] != ' ') {
                ++index;
                if (index >= len) {
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
        String reverseS = reverseWords1(s);
        System.out.println(reverseS);
    }
}
