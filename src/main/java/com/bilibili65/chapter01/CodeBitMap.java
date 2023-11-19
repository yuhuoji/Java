package com.bilibili65.chapter01;

import org.junit.Test;

import java.util.HashMap;

/**
 * @date 2023-02-23 10:37
 * 位图
 * int -> 00000000 00000000 00000000 00000000 -> 记录0~31是否出现过
 */
public class CodeBitMap {

    public static class BitMap {
        //int -> 4byte -> 32bit, long -> 8byte -> 64bit
        //bits[0] 0~63, bits[1] 64~127, bits[0] ...
        private long[] bits;

        public BitMap(int max) {
            //(max+64)/64
            bits = new long[(max + 64) >> 6];
        }

        // |00010000
        public void add(int num) {
            //num/64 = num>>6
            //num%64 = num&63 0...0 01111111
            //+-*/%速度不如<<>>&|^
            //1默认为int 32位， 1L是 64位
//            bits[num >> 6] = bits[num / 64] | (1L << (num & 63));
            bits[num >> 6] |= (1L << (num & 63));
        }

        // &11101111
        public void delete(int num) {
            //00010000 -> 11101111
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        // &00010000
        public boolean contain(int num) {
            //0 -> not contain num, 1 -> contain num
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

        @Test
        public void test() {
            int max = 1000;
            BitMap bitMap = new BitMap(max);
            HashMap hashMap = new HashMap<>();

        }
    }
}
