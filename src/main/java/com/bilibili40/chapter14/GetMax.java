package com.bilibili40.chapter14;

public class GetMax {
    /**
     * @param n 1 or 0
     * @return 0 -> 1, 1 -> 0
     */
    public int flip(int n) {
        return n ^ 1;
    }

    /**
     *
     * @param n n
     * @return 非负数返回1，负数返回0
     */
    public int getSign(int n) {
        //负数 1 -> 1
        //非负数 0 -> 0
        return flip((n >> 31) & 1);
    }
}
