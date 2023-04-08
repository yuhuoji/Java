package com.bilibili40.chapter14;

/**
 * @date 2023-04-08
 * 位运算，幂
 * 判断32位正数是不是2的幂，4的幂
 */
public class Power {
    public boolean is2Power(int n) {
        return (n & (n - 1)) == 0; //是否只有一位为1
    }

    public boolean is4Power(int n) {
        //是2的幂，1出现的位置是0、2、4、6
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0; //01..1010101共32位
    }
}
