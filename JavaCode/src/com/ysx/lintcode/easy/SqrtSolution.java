package com.ysx.lintcode.easy;

/**
 * 141. x的平方根
 * http://www.lintcode.com/zh-cn/problem/sqrtx/
 */
public class SqrtSolution {

    public static void main(String[] args) {
        SqrtSolution test = new SqrtSolution();

        System.out.println(test.sqrt(8));
        System.out.println(test.sqrt(9));
    }

    /*
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int begin = 1;
        int end = x;
        int middle = (begin + end) / 2;
        while(begin <= end) {
            /**
             * 注意，如果使用middle * middle 与 x判断的时候，可能会溢出
             */
            if (x / middle == middle) {
                return middle;
            } else if (x / middle > middle) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
            middle = (begin + end) / 2;
        }
        return middle;
    }
}
