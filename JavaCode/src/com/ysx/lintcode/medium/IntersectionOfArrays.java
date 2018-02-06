package com.ysx.lintcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 793. 数组的交集
 * http://www.lintcode.com/zh-cn/problem/intersection-of-arrays/
 */
public class IntersectionOfArrays {

    public static void main(String[] args) {
        int[][] arrs1 = {{1, 2, 3}, {3, 4, 5}, {3, 9, 10}};
        IntersectionOfArrays test = new IntersectionOfArrays();
        System.out.println(test.intersectionOfArrays(arrs1));

        int[][] arrs2 = {{1, 2, 3, 4}, {1, 2, 5, 6, 7}, {9, 10, 1, 5, 2, 3}};
        System.out.println(test.intersectionOfArrays(arrs2));
    }

    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        if (null == arrs || arrs.length == 0) {
            return 0;
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < arrs[0].length; i++) {
            resultSet.add(arrs[0][i]);
        }
        Set<Integer> tempSet = new HashSet<>();
        for (int i = 1; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                if (resultSet.contains(arrs[i][j])) {
                    tempSet.add(arrs[i][j]);
                }
            }
            resultSet.clear();
            resultSet.addAll(tempSet);
            tempSet.clear();
        }
        return resultSet.size();
    }
}
