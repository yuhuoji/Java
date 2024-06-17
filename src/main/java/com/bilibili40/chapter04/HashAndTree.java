package com.bilibili40.chapter04;

import org.junit.jupiter.api.Test;

import java.util.*;

/*
* */
public class HashAndTree {


    @Test
    public void test() {
        /* 哈希表 无序
         * hashSet（key）和hashMap（key, value）, 这俩底层是一样的
         * 操作时间复杂度O（1）
         * */
        System.out.println("=============\n哈希表");
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(1);
        System.out.println(hashSet1.contains(1));
        hashSet1.remove(1);
        System.out.println(hashSet1.contains(1));


        HashMap<Integer, String> hashMap1 = new HashMap<>();
        /* 有序表 有序
         * TreeSet TreeMap
         * 操作时间复杂度O(log(No))
         * */
        System.out.println("=============\n有序表");
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        treeSet1.add(1);

        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(0, "我是0");
        treeMap1.put(1, "我是1");
        treeMap1.put(2, "我是2");
        treeMap1.put(3, "我是3");
        treeMap1.put(4, "我是4");
        treeMap1.put(5, "我是5");
        treeMap1.put(6, "我是6");
        treeMap1.put(7, "我是7");
        System.out.println(treeMap1.containsKey(1));
        System.out.println(treeMap1.get(0));
        System.out.println("我是" + treeMap1.firstKey() + ", 我最大");
        System.out.println("我是" + treeMap1.lastKey() + ", 我最小");
        System.out.println("我是" + treeMap1.floorKey(5) + ", 在<=5的数里， 我离5最近");
        System.out.println("我是" + treeMap1.ceilingKey(3) + ", 在>=3的数里， 我离3最近");
        treeMap1.remove(3);
        System.out.println(treeMap1.get(3) + "已删除");

    }
}
