package com.ysx.leetcode.easy;

/**
 * 760. Find Anagram Mappings
 * https://leetcode.com/problems/find-anagram-mappings/description/
 * <p>
 * eg.
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * output:
 * [1, 4, 3, 2, 0]
 */
public class AnagramMappings {

    public static void main(String[] args) {
        AnagramMappings test = new AnagramMappings();
        int[] A = new int[]{12, 28, 46, 32, 50};
        int[] B = new int[]{50, 12, 32, 46, 28};
        int[] result = test.anagramMappings(A, B);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (A[i] == B[j]) {
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }
}
