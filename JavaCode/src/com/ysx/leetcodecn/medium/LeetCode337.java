package com.ysx.leetcodecn.medium;

import com.ysx.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/31 19:20
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 337. 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class LeetCode337 {
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * 返回一个数组 result[2]
     * result[0] 表示不偷当前节点，当前节点可以偷到的最大值：左孩子可以偷到的钱+右孩子可以偷到的钱
     * result[1] 表示偷当前节点，当前节点可以偷到的最大值： 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     * 即
     * root[0] = Math.max(robInternal(root.left)[0] + robInternal(root.left)[1]) + Math.max(robInternal(root.right)[0] +
     * robInternal(root.right)[1])
     * root[1] = robInternal(root.left)[0] + robInternal(root.right)[0] + root.val
     * 最后返回： Math.max(root[0], root[1])
     *
     * @param root
     * @return
     */
    private int[] robInternal(TreeNode root) {
        int[] result = new int[2];
        Arrays.fill(result, 0);
        if (null == root) {
            return result;
        }
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }

    /**
     * 使用缓存保存节点的值
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return robWithCache(root, map);
    }

    private int robWithCache(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (null == root) {
            return 0;
        }
        // money表示选择爷爷节点+4个孙子节点
        int money1 = root.val;
        if (null != root.left) {
            money1 += (robWithCache(root.left.left, map) + robWithCache(root.left.right, map));
        }
        if (null != root.right) {
            money1 += (robWithCache(root.right.left, map) + robWithCache(root.right.right, map));
        }
        // money2表示选择两个子节点
        int money2 = robWithCache(root.left, map) + robWithCache(root.right, map);
        int money = Math.max(money1, money2);
        // 缓存到map中
        map.put(root, money);
        return money;
    }

    /**
     * 暴力解法-最优子结构
     * @param root
     * @return
     */
    public int rob3(TreeNode root) {
        if (null == root) {
            return 0;
        }
        // money表示选择爷爷节点+4个孙子节点
        int money1 = root.val;
        if (null != root.left) {
            money1 += (rob3(root.left.left) + rob3(root.left.right));
        }
        if (null != root.right) {
            money1 += (rob3(root.right.left) + rob3(root.right.right));
        }
        // money2表示选择两个子节点
        int money2 = rob3(root.left) + rob3(root.right);
        return Math.max(money1, money2);
    }
}
