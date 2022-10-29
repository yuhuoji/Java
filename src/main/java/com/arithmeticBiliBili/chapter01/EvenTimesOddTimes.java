package com.arithmeticBiliBili.chapter01;

public class EvenTimesOddTimes {
    /* 异或操作 */
    /* 一个数组里有一种数出现奇数次，其他数都出现偶数次，找出这个数a */
    public void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }
        System.out.println("a = " + eor);
    }

    /* 一个数组里有两种数出现奇数次，其他数都出现偶数次，找出这两个数ab */
    public void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }
        /* eor = a^b != 0 so eor 至少有一位必为1 */
        //！！！提取最右侧的1，原码&补码=最右侧的1
        int rightOne = eor & (~eor + 1);

        /* */
        int onlyZero = 0;
        for (int curNum : arr) {
            if ((curNum & rightOne) == 0) // 等于0取出rightOne位为0的数，等于1取出rightOne位位1的数
                onlyZero ^= curNum;
        }
        /* 一个数是a, eor = a^b, eor^a = b*/
        System.out.println(onlyZero + ", " + (eor ^ onlyZero));
    }
}
