package com.bilibili40.chapter09;

import java.util.List;

/**
 * @date 2022-12-03 23:28
 * 打印所有子序列，包括空字符串
 */
public class PrintAllSubsequence {
    public void printAllSubsequence(String string) {
        char[] chars = string.toCharArray();
        process(chars, 0);
    }

    /**
     * @param str 所有的字符，在过程中会改变，用于子过程的递归，节省空间
     * @param i   现在来到i位置
     */
    private void process(char[] str, int i) {
        if (i == str.length) { //base case 结束
            System.out.println(String.valueOf(str)); //打印
            return;
        }
        //case 1 选择当前字符
        process(str, i + 1);
        //case 2 不选择当前字符，用变量保存，ASCII = 0 ==> null
        char tmp = str[i]; //暂存str[i]
        str[i] = 0;
        process(str, i + 1);
        str[i] = tmp; //恢复
    }

    /**
     * @param chars 所有的字符
     * @param i     现在来到i位置
     * @param res   之前的选择形成的列表
     */
    private void process(char[] chars, int i, List<Character> res) {
        if (i == chars.length) { //base case 结束
            printList(res);
            return;
        }
        //case 1 选择当前字符
        List<Character> resSelectCurChar = copyList(res);
        resSelectCurChar.add(chars[i]);
        process(chars, i + 1, resSelectCurChar); //继续递归
        //case 2 不选择当前字符
        List<Character> resNotSelectCurChar = copyList(res);
        process(chars, i + 1, resNotSelectCurChar);
    }

    private void printList(List<Character> res) {
        //TODO
    }

    private List<Character> copyList(List<Character> list) {
        return null; //TODO
    }
}
