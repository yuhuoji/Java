package com.bilibili65.chapter01;

import org.junit.Test;

/**
 * @date 2023-02-22 14:52
 * 位运算，输出32进制的数
 */
public class CodePrintBinary {
    public void print(int num) {
        for (int i = 31; i >= 0; i--) {
            //8 16 24
            if (i==23||i==15||i==7){
                System.out.print(" ");
            }
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }

    @Test
    public void test(){
        print(128);
    }
}
