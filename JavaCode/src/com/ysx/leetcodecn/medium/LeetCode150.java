package com.ysx.leetcodecn.medium;

import java.util.Stack;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2020/1/2 21:51
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class LeetCode150 {

    /**
     * 使用一个栈来保存
     * 循环数组，如果是数字，则入栈；如果是运算符，当前栈顶两个元素出栈，并使用该运算符运算，再入栈
     * 最后返回栈顶元素
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int e2 = stack.pop();
                    int e1 = stack.pop();
                    stack.push(operate(e1, e2, token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    /**
     * 运算
     *
     * @param e1
     * @param e2
     * @param op
     * @return
     */
    private int operate(int e1, int e2, String op) {
        switch (op) {
            case "+":
                return e1 + e2;
            case "-":
                return e1 - e2;
            case "*":
                return e1 * e2;
            case "/":
                return e1 / e2;
            default:
                return 0;
        }
    }
}
