package com.ysx.leetcodecn.easy;

import java.util.Stack;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/28 20:18
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
public class Number155 {
    private Stack<Integer> stack;
    // 存储当前栈中最小元素于栈顶
    private Stack<Integer> min;

    public Number155() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.empty()) {
            min.push(x);
        } else if (min.peek() > x) {
            // 如果x小于当前min的最小元素，则将x作为最小元素push到min的栈顶
            min.push(x);
        } else {
            // 否则，选择当前的最小的元素push在栈顶
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
