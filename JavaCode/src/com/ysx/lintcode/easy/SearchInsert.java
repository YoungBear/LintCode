package com.ysx.lintcode.easy;

/**
 * Lintcode 60. 搜索插入位置
 * http://www.lintcode.com/zh-cn/problem/search-insert-position/
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert test = new SearchInsert();
        int[] A1 = {1, 3, 5, 6};
        int target1 = 5;
        int target2 = 2;
        int target3 = 7;
        int target4 = 0;
        System.out.println(test.searchInsert(A1, target1));
        System.out.println(test.searchInsert(A1, target2));
        System.out.println(test.searchInsert(A1, target3));
        System.out.println(test.searchInsert(A1, target4));
    }

    /*
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= target) {
                return i;
            }
        }
        return A.length;
    }
}
