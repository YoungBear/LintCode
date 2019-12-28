# [Leetcode 155. 最小栈](https://leetcode-cn.com/problems/min-stack/)

## 1. 题目描述

设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

- push(x) -- 将元素 x 推入栈中。
- pop() -- 删除栈顶的元素。
- top() -- 获取栈顶元素。
- getMin() -- 检索栈中的最小元素。

## 2. 思路

使用两个栈，stack用于存储元素，min用于存储当前stack中的最小的元素，即min的栈顶为当前stack中的最小元素。

**条件：**

- push(x)的时候，如果x比当前min的栈顶元素小，则将x放到min的栈顶；否则，将min的栈顶元素，再push同一个放在其栈顶。
- pop元素的时候，stack和min同时pop。
- stack和pop的size是相同的。

## 3. java 代码

```java
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
```

