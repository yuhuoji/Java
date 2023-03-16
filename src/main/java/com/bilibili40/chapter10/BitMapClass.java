package com.bilibili40.chapter10;

import org.junit.Test;

/**
 * @date 2023-03-16 15:49
 * 位图
 * 布隆过滤器
 * m = -(n*lnP)/(ln2)^2 , 样本量n，失误率P，向上取整
 * k = ln2*m/n = 0.7*m/n
 * P真=(1 - e^(-n*k真/m真))^k真
 * 一致性哈希，分布式数据库，redis cluster原理
 */
public class BitMapClass {
    @Test
    public void test() {
        //位图
        int[] array = new int[10]; //32bit * 10 = 320bit
        //int[0] 4B 32bit
        int i = 178; //取得i位置的信息
        int numIndex = i / 32;
        int bitIndex = i % 32;
        int s = (array[numIndex]) >> (bitIndex) & 1; //取出i位信息 syndrome
        array[numIndex] = array[numIndex] | (1 << bitIndex); //将i位置设置为1
        array[numIndex] = array[numIndex] & (~(1 << bitIndex)); //将i位置设置为0

    }
}
