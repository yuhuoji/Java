package com.bilibili40.chapter11;

/**
 * @date 2023-03-18
 * KMP
 */
public class KMPClass {
    /**
     * @param s 主字符串
     * @param m 匹配字符串
     * @return 开始的位置，如果不包含返回-1
     */
    public int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0, i2 = 0;
        int[] next = getNextArray(str2); //获得next数组 O(M)
        //O(str1.length)
        while (i1 < str1.length && i2 < str2.length) { //不越界
            if (str1[i1] == str2[i2]) { //字符相等
                ++i1;
                ++i2;
            } else if (next[i2] == -1) { //str2已经移动到开头
                ++i1; //主串用下一个位置开始重新匹配
            } else {
                i2 = next[i2]; //从最长前缀下一个位置开始匹配，i2向前移动相当于待匹配字符串向右移动
            }
        }
        //i1越界（没匹配成功） or i2越界（匹配成功了）
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     * 计算next数组
     * 时间复杂度O(str2.length)
     * @param ms 字符数组
     * @return 返回next数组
     */
    public int[] getNextArray(char[] ms) {
        if (ms.length == 1) { //长度为1，0位置规定为-1
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1; //规定0位置-1
        next[1] = 0; //规定1位置0
        int i = 2; //next数组从2开始计算
        int cn = 0; //开始时用cn与i-1比较，前缀下一位的坐标
        while (i < ms.length) {
            if (ms[cn] == ms[i - 1]) {
                next[i] = ++cn;
                i++;
            } else if (cn>0) { //当前cn位置的字符与i-1比对不上
                cn=next[cn]; //cn往前跳
            }else {
                next[cn++]=0;
            }
        }
        return next;
    }
}
