package com.ysx.lintcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * http://www.lintcode.com/zh-cn/problem/digit-divide-numbers/
 * 742. Digit Divide Numbers
 *
 */
public class DigitDivideNumbers {

    public static void main(String[] args) {
        DigitDivideNumbers test = new DigitDivideNumbers();
        System.out.println(test.digitDivideNums(2147483000, 2147483647));
    }
    /**
     * @param lower: Integer : lower bound
     * @param upper: Integer : upper bound
     * @return: a list of every possible Digit Divide Numbers
     */
    public List<Integer> digitDivideNums(int lower, int upper) {
        /**
         * 需要判断i是否大于等于0，因为Integer的范围是-2^32 -到 2^32 -1
         * 即-2147483648 到 2147483647
         * 当2147483647再加1的时候，由于超出了Integer的最大值，所以结果就变成了-2147483648
         * 就会导致一直死循环。
         */
        List<Integer> resultList = new LinkedList<>();
        for (int i = lower; i >= 0 && i <= upper; i++) {
            if (isDigitDivideNum(i)) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    /**
     * 判断一个数是否可以被每一位的数整除
     * @param n
     * @return
     */
    public static boolean isDigitDivideNum(int n) {
        int temp = n;
        for (int i = temp % 10; temp > 0; temp = temp / 10, i = temp % 10) {
            if (i == 0 || n % i != 0) {
                return false;
            }
        }
        return true;
    }
}
