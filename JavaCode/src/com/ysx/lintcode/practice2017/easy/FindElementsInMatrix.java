package com.ysx.lintcode.practice2017.easy;

/**
 * 737. Find Elements in Matrix
 * http://www.lintcode.com/zh-cn/problem/find-elements-in-matrix/
 * 找出每一行都出现的元素
 */
public class FindElementsInMatrix {

    public static void main(String[] args) {
//        int [][]data = {{2,5,3}, {3,2,1}, {1,3,5}};
//        int [][]data = {{1,1,3,4,5},{9,20,1,1,100},{100,1,200,300,400}};
        int [][]data = {{1,2,3,4},{4,5,6,7},{2,2,1,4},{4,4,3,9}};
        FindElementsInMatrix test = new FindElementsInMatrix();
        System.out.println(test.FindElements(data));

    }

    /**
     * 遍历第一行数据的每一个元素，如果某一个元素在每行均出现，则返回该元素
     *
     * @param Matrix: the input
     * @return: the element which appears every row
     */
    public int FindElements(int[][] Matrix) {
        // write your code here
        int row = Matrix.length;
        int column = Matrix[0].length;
        if (row == 1) {
            return Matrix[0][0];
        }
        for (int i = 0; i < column; i++) {
            // 第一行的每一个元素
            int n = Matrix[0][i];
            boolean flag = true;
            for (int j = 1; flag && j < row; j++) {
                boolean flagk = false;
                for (int k = 0; k < column; k++) {
                    // 如果在这一行已经出现该元素，则跳出循环
                    if (n == Matrix[j][k]) {
                        flagk = true;
                        break;
                    }
                }
                // 如果在这一行没有找到该元素，则表明n不是需要的元素，取下一个候选元素
                if (!flagk) {
                    flag = false;
                    break;
                }

            }
            // 如果每一行都出现了该元素，则满足条件，返回
            if (flag) {
                return n;
            }
        }
        // 默认返回第一个元素
        return Matrix[0][0];
    }
}
