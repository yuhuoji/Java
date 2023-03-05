package com.leetcode.algorithm.day6;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @date 2023-03-05 14:35
 * 滑动窗口
 * TODO 3，30，76，159，209，239，567，632，727
 */
public class Leetcode3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring0(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Queue<Character> queue = new ArrayDeque<>();
        int index = 0;
        int maxLength = 0;
        while (index < s.length()) { //依次遍历所有字符
            if (!queue.contains(s.charAt(index))) { //不重复
                queue.offer(s.charAt(index++));
            } else { //重复
                queue.poll();
            }
            maxLength = Math.max(maxLength, queue.size());
        }
        return maxLength;
    }

    //官方题解
    //hashmap判断是否重复，left ~ i存当前队列里的字符串，出现重复left一步移动
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxLength = 0;
        int left = 0; //left始终指向无重复元素的子串（滑动窗口）的起始位置
        for (int i = 0; i < s.length(); ++i) {
            if (hashMap.containsKey(s.charAt(i))) { //重复
                //
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1); //如abba，防止left回退
                //
            }
            //添加新字符（更新）
            hashMap.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    @Test
    public void test() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring1(s));
    }
}
