package com.ysx.lintcode.easy;

/**
 * Lintcode 172. 删除元素
 * http://www.lintcode.com/zh-cn/problem/remove-element/
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        int[] A = {0, 4, 4, 0, 0, 2, 4, 4};
        int elem = 4;
        System.out.println(test.removeElement(A, elem));
        for (int i : A) {
            System.out.println(i);
        }
    }

    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int count = len;
        int i = 0;
        while (i < len) {
            if (elem == A[i]) {
                count--;
                len--;
                for (int j = i; j < len; j++) {
                    A[j] = A[j + 1];
                }
            } else {
                i++;
            }
        }
        return count;
    }
}
