package com.bilibili40.chapter12;

import org.junit.jupiter.api.Test;

/**
 * @date 2023-03-20
 * Manacher
 */
public class ManacherClass {

    /**
     * 处理字符串
     *
     * @param s 字符串 1221
     * @return #1#2#2#1#
     */
    private char[] manacherString(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length * 2 + 1]; //奇数
        for (int i = 0, index = 0; i < res.length; ++i) {
            res[i] = (i & 1) == 0 ? '#' : chars[index++]; //奇数为#，偶数为原先字符
        }
        return res;
    }

    /**
     * manacher
     *
     * @param s 字符串
     * @return 最长回文字串长度
     */
    public int maxLcpsLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length]; //回文数组
        int C = -1; //回文中心
        int R = -1; //回文右边界再往右一位
        int max = Integer.MAX_VALUE; //最大回文串长度
        for (int i = 0; i < str.length; ++i) { //str每个位置都求回文半径
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1; //四种情况，不需要比较的回文串长度，至少为1
            while (i + pArr[i] < str.length && i - pArr[i] > -1) { //不越界
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break; //两种不需要比较的情况，一次失败退出循环
                }
                if (i + pArr[i] > R) { //更新R C
                    R = i + pArr[i];
                    C = i;
                }
                max = Math.max(max, pArr[i]);
            }
        }
        return max - 1; //原字符串最大回文串长度==处理后字符串最大回文串长度-1
    }

    @Test
    public void test() {
        int a = 6;
        System.out.println(a | 1);
    }
}
