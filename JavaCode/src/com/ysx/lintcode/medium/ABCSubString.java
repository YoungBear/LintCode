package com.ysx.lintcode.medium;

/**
 * 734. 形式为a^i b^j c^k的子序列数量
 * http://www.lintcode.com/zh-cn/problem/number-of-subsequences-of-form-ai-bj-ck/
 */
public class ABCSubString {

    public static void main(String[] args) {
        ABCSubString test = new ABCSubString();
        System.out.println("abbc: " + test.countSubsequences("abbc"));
        System.out.println("abcabc: " + test.countSubsequences("abcabc"));

    }

    /*
     * @param : the input string
     * @return: the number of subsequences
     */
    public int countSubsequences(String source) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        for (int i = 0; i < source.length(); i++) {
            switch (source.charAt(i)) {
                case 'a':
                    aCount = aCount + aCount + 1;
                    break;
                case 'b':
                    bCount = aCount + bCount + bCount;
                    break;
                case 'c':
                    cCount = bCount + cCount + cCount;
                    break;
                default:
                    break;
            }
        }
        return cCount;
    }
}
