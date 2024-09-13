package com.bilibili40.chapter09;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @date 2022-12-04 14:42
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数。如何实现?
 */
public class ReverseStackUsingRecursive {

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()){ //base case
            return;
        }
        int i = removeBottomAndReturn(stack); //移除并获取栈底元素
        reverse(stack); //黑盒，递归，子过程，逆序剩下的栈
        stack.push(i); //栈底元素压栈
    }

    //移除并返回栈底元素
    private int removeBottomAndReturn(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) { //只触发一次，用于返回栈底元素
            return result;
        } else {
            int last = removeBottomAndReturn(stack); //最后一次result接收倒数第二个元素，last接收最后一个元素，last递归返回，result再依次压栈
            stack.push(result);
            return last; //栈底元素
        }
    }

    @Test
    public void test(){

    }
}
