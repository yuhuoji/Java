package com.leetcode.algorithm.day6;

import org.junit.Test;

/**
 * @date 2023-03-05 15:21
 * TODO 76,567,438
 */
public class Leetcode567PermutationInString {
    //方法一：滑动窗口
    public boolean checkInclusion1(String s1, String s2) {
        int length1 = s1.length(), length2 = s2.length();
        if (length1 > length2) {
            return false;
        }
        int[] count = new int[26]; //统计出现字符数
        //前length1个字符
        for (int i = 0; i < length1; ++i) {
            --count[s1.charAt(i) - 'a'];
            ++count[s2.charAt(i) - 'a'];
        }
        int difference = 0; //count中不为0的
        for (int c : count) {
            if (c != 0) {
                ++difference;
            }
        }
        if (difference == 0) { //前n个字符就是排序
            return true;
        }
        //s2剩余字符
        for (int i = length1, x = 0, y = 0; i < length2; ++i) {
            //y ~ x-1维护长度为length1的滑动窗口
            x = s2.charAt(i) - 'a'; //当前字符
            y = s2.charAt(i - length1) - 'a'; //队列第一个
            if (x == y) { //字符相同，相当于替换了，不用增删
                continue;
            }
            //窗口右侧增加
            if (count[x] == 0) {
                ++difference;
            }
            ++count[x];
            if (count[x] == 0) {
                --difference;
            }
            //窗口左侧删除
            if (count[y] == 0) {
                ++difference;
            }
            --count[y];
            if (count[y] == 0) {
                --difference;
            }
            //判断是否相同
            if (difference == 0) {
                return true;
            }
        }
        return false;
    }

    //方法二：双指针
    public boolean checkInclusion2(String s1, String s2) {
        return false;
    }

    @Test
    public void test() {
        String s = "pwwkew";

    }
}

