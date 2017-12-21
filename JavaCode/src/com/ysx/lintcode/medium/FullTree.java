package com.ysx.lintcode.medium;


/**
 * 726. 验证满二叉树
 * http://www.lintcode.com/zh-cn/problem/check-full-binary-tree/
 */
public class FullTree {

    /*
     * @param : the given tree
     * @return: Whether it is a full tree
     */
    public boolean isFullTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.right == null) ||
                (root.left == null && root.right != null)) {
            return false;
        }
        return isFullTree(root.left) && isFullTree(root.right);
    }

    private static final class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

    }


}
