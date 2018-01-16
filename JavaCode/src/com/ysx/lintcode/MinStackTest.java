package com.ysx.lintcode;

import com.ysx.lintcode.medium.MinStack;

public class MinStackTest {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.pop();
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(1);
        System.out.println(minStack.min());
    }
}
