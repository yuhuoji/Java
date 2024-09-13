package com.bilibili40.chapter09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022-12-04 13:26
 * leetcode 46
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permutation {
    public ArrayList<String> permutation(String string) {
        ArrayList<String> res = new ArrayList<>();
        if (string == null || string.length() == 0) {
            return res;
        }
        char[] chars = string.toCharArray();
        process(chars, 0, res);
        return res;
    }

    /**
     * 从左往右尝试
     * @param str [0~i-1]已经做完的选择， [i]当前的选择
     * @param i   当前的位置
     * @param res 所有字符的全排列
     */
    private void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) { //base case
            res.add(String.valueOf(str));
        }
        //分支限界，用visit去重，每个位置一个字符只尝试一次，visit[0~25] <=> a~z
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) { //i~str.length-1的字符都可以在i位置
            if (!visit[str[j] - 'a']) { //只有当false时表示第一次尝试，为true表示尝试过了会有重复
                visit[str[j] - 'a'] = true;
                //每次选择j位置的字符
                swap(str, i, j);
                process(str, i + 1, res);
                swap(str, i, j); //恢复
            }
        }
    }

    private void printList(List<String> res) {
        res.stream().forEach(System.out::println);
    }

    //交换i和j位置的字符
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    @Test
    public void test() {
        List<String> res = permutation("abcde");
        printList(res);
    }
}
