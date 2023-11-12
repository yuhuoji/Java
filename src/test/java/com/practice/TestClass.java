package com.practice;

import com.leetcode.helper.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) {

        String[] array = {"apple", "banana", "orange"};
        // 使用 Arrays.asList() 转换为列表
        List<String> listFromArray = Arrays.asList(array);

        System.out.println("List from array: " + listFromArray);
        System.out.println(listFromArray.get(2));
    }
}