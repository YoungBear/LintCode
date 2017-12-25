package com.ysx.lintcode.medium;

import com.ysx.lintcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 11. 二叉查找树中搜索区间
 * http://www.lintcode.com/zh-cn/problem/search-range-in-binary-search-tree/
 *
 */
public class BinarySearchTreeNode {

    public static void main(String[] args) {
        BinarySearchTreeNode test = new BinarySearchTreeNode();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        System.out.println(test.searchRange(root, 0, 4));
//        System.out.println(test.searchRange(root, 195, 1100));
        //{1100,1000,#,900,#,8,#,#,100,#,101,#,200,190,#,183,#,172,#,161}
//        List<Integer> testList = Arrays.asList(8, 100, 101, 161, 172, 183, 190, 200, 900, 1000, 1100);
    }

    /*
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> searchList = getSearchList(root);
        int start = 0, end = 0;
        int length = searchList.size();
        if (length == 0 || searchList.get(0) > k2 || searchList.get(length - 1) < k1) {
            return searchList.subList(0, 0);
        }
        for (int i = 0; i < length; i++) {
            if (searchList.get(i) >= k1) {
                start = i;
                break;
            }
        }

        for (int i = start; i < length; i++) {
            if (searchList.get(i) > k2) {
                end = i;
                break;
            }
        }
        if (end == 0) {
            end = length;
        }
        return searchList.subList(start, end);

    }

    /**
     * 生成有序列表
     * @param root
     * @return
     */
    private List<Integer> getSearchList(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();
        if (root != null) {
            resultList.addAll(getSearchList(root.left));
            resultList.add(root.val);
            resultList.addAll(getSearchList(root.right));
        }
        return resultList;
    }
}
