package com.ysx.lintcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 带最小值操作的栈
 * http://www.lintcode.com/zh-cn/problem/min-stack/
 */
public class MinStack {
    // mData模拟一个栈
    private List<Integer> mData;
    // mMinData用来存储最小的值，并且当前最小的值是最后一个元素
    private List<Integer> mMinData;
    public MinStack() {
        mData = new LinkedList<>();
        mMinData = new LinkedList<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        mData.add(number);
        // 第一次push，将第一个元素添加到mMinData中
        if (mMinData.size() == 0) {
            mMinData.add(number);
        } else {
            // 之后，将number与mMinData中的最小值比较，将较小的值添加到mMinData中
            mMinData.add(Math.min(number, mMinData.get(mMinData.size() - 1)));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int top = mData.get(mData.size() - 1);
        mData.remove(mData.size() - 1);
        mMinData.remove(mMinData.size() - 1);
        return top;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return mMinData.get(mMinData.size() - 1);
    }
}
