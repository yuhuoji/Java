package com.bilibili65.chapter01;

import org.junit.Test;

/**
 * @date 2023-02-23 14:26
 */
public class BitAddSubtractMultiplyDivide {
    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b; //无进位相加信息
            b = (a & b) << 1; //b = 进位信息
            a = sum; //a = 无进位相加信息
//            System.out.println("sum = a = " + Integer.toBinaryString(a) + ", b = " + Integer.toBinaryString(b));
        }
        //直到进位信息==0，无进位相加信息就是结果
        return sum;
    }

    public int subtract(int a, int b) {
        return add(a, oppositeNumber(b));
    }

    public int oppositeNumber(int n) {
        return add(~n, 1);
    }

    public int multiply(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) { //b最后一位是否为0
                res = add(res, a);
            }
            System.out.println("a = " + Integer.toBinaryString(a) + ", b = " + Integer.toBinaryString(b) + ", res = " + Integer.toBinaryString(res));
            a <<= 1;
            /*
            ;SHL(Shift Left):             逻辑左移
            ;SHR(Shift Right):            逻辑右移
            ;SAL(Shift Arithmetic Left):  算术左移
            ;SAR(Shift Arithmetic Right): 算术右移
            shl和sal一样，低位补0；shr高位补0，sar高位补1
            b>>1 右移运算符 sar
            b>>>1 无符号右移运算符 shr
            对于有符号整数，右移采用的是sar指令； 而对于无符号整数，右移则采用的是shr指令
            */
            b >>>= 1;
        }
        return res;
    }

    private boolean isNegative(int n) {
        return n < 0;
    }

    //不含Integer.MIN_VALUE
    public int divideWithoutMINVALUE(int a, int b) {
        if (b == 0) {
            return 0;
        }
        int x = isNegative(a) ? oppositeNumber(a) : a;
        int y = isNegative(b) ? oppositeNumber(b) : b;
        //x, y > 0
        int res = 0;
        //x 0~30位
        for (int i = 30; i >= 0; subtract(i, 1)) {
            if ((x >> i) >= y) { //y左移够x(溢出，符号位) <=> x右移够y(安全)
                res |= (1 << i);
                x = subtract(x, y << i);
            }
        }
        return isNegative(a) ^ isNegative(b) ? oppositeNumber(res) : res;
    }

    public int divide(int dividend, int divisor) {
        //Integer.MIN_VALUE和 Integer.MAX_VALUE不对应，-Integer.MIN_VALUE==Integer.MIN_VALUE，Integer.MIN_VALUE/num不能转换成-Integer.MIN_VALUE/num
        if (dividend == Integer.MIN_VALUE & divisor == Integer.MIN_VALUE) { //case1
            return 1;
        } else if (divisor == Integer.MIN_VALUE) { //case2
            return 0;
        } else if (dividend == Integer.MIN_VALUE) { //case3
            if (divisor == oppositeNumber(1)) {
                //leetcode约定
                return Integer.MAX_VALUE;
            } else {
                //ans = a/b
                //ans + 1/b= (a+1)/b = c
                //a+1=b*c+d
                //a-b*c=d
                //d/b=e
                //ans = c+e
                int c = divideWithoutMINVALUE(add(dividend, 1), divisor);
                return add(c, divideWithoutMINVALUE(subtract(dividend, multiply(divisor, c)), divisor));
            }
        } else {
            //case4 都不是系统最小值
            return divideWithoutMINVALUE(dividend, divisor);
        }
    }

    @Test
    public void test() {
//        add(3, 5);
        multiply(3, 5);
    }
}
