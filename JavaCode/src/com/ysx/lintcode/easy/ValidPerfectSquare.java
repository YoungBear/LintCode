package com.ysx.lintcode.easy;

/**
 * 777. Valid Perfect Square
 * http://www.lintcode.com/zh-cn/problem/valid-perfect-square/
 * 判断一个数是否为平方数，不要使用Math.sqrt之类的库函数
 * 使用累加的方式遍历，会超时。
 * 所以考虑使用二分法
 * 需要注意的是，二分法的上界是Math.sqrt(Integer.MAX_VALUE)，取整为46340
 */
public class ValidPerfectSquare {

    private static final int MAX_SQRT = 46340;

    public static void main(String[] args) {
        ValidPerfectSquare test = new ValidPerfectSquare();
//        for (int i = 1; i <= 100; i++) {
//            System.out.println(i + " : " + test.isPerfectSquare(i));
//        }
        System.out.println(test.isPerfectSquare(1000000));
//        System.out.println(Math.sqrt(Integer.MAX_VALUE));


    }

    /**
     * @param num: a positive integer
     * @return: if num is a perfect square else False
     */
    public boolean isPerfectSquare(int num) {
        int begin = 0;
        int end = 2 * MAX_SQRT;
        int middle = (begin + end) / 2;
        while (begin <= end && middle <= MAX_SQRT) {
            int temp = middle * middle;
            if (temp < num) {
                begin = middle + 1;
            } else if (temp > num) {
                end = middle - 1;
            } else {
                return true;
            }
            middle = (begin + end) / 2;
        }
        return false;
    }
}
