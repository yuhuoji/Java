package com.bilibili.chapter08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @date 2022-11-26 15:47
 * 贪心
 * 贪心策略在实现时,经常使用到的技巧:
 * 1,根据某标准建立一个比较器来排序
 * 2,根据某标准建立一个比较器来组成堆
 * ================
 * 字典序：
 * 相同从高位开始比较（a~z -> 1~26），不同长度先将短的后面加0补成相同长度再比较
 *
 * abc和de进行拼接，"abc"."de" => "abcde"
 * 相当于k进制的数（26+1(0)进制的数） abc.de <==> abc * pow(k,2) + de
  */
public class LowestLexicography {
    /**
     * @param strings 拼接的字符串数组
     * @return 拼接后的字符，字典序最小
     */
    public String lowestString(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        Arrays.sort(strings, new MyComparator());
        String res = ""; //返回的拼接字符串
        for (int i = 0; i < strings.length; i++) {
            res += strings[i];
        }
        return res;
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) { //compare返回字典序
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
}
