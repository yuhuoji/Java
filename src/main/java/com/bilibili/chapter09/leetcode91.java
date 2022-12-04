package com.bilibili.chapter09;

import org.junit.Test;

/**
 * @date 2022-12-04 15:02
 */
public class leetcode91 {
    public int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    /**
     * 从左向右尝试
     *
     * @param str [0 ~ i-1]已经确定，[i ~]有多少可能的结果
     * @param i   当前位置
     * @return 个数
     */
    private int process(char[] str, int i) {
        if (i == str.length) { //base case，0~i-1已经确认，i位置结果总共有1种
            return 1;
        }
        if (str[i] == '0') { //0没有对应
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1); //i单独,1
            if (i + 1 < str.length) {
                res += process(str, i + 2); //i和i+1，10~19
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1); //i单独,2
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) { //20~26
                res += process(str, i + 2);
            }
            return res;
        }
        //i单独，3~9
        return process(str, i + 1);
    }
    @Test
    public void test(){
        System.out.println(number("11111"));
    }
}
