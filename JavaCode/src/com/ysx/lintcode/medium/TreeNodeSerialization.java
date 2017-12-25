package com.ysx.lintcode.medium;

import com.ysx.lintcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 7. 二叉树的序列化和反序列化
 * http://www.lintcode.com/zh-cn/problem/binary-tree-serialization/
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * 参考：
 * https://discuss.leetcode.com/topic/31264/short-and-straight-forward-bfs-java-code-with-a-queue
 */
public class TreeNodeSerialization {

    public static void main(String[] args) {
        TreeNodeSerialization test = new TreeNodeSerialization();
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        root.left = left1;
        TreeNode right1 = new TreeNode(20);
        root.right = right1;
        TreeNode left2 = new TreeNode(15);
        right1.left = left2;
        TreeNode right2 = new TreeNode(7);
        right1.right = right2;
        String result = test.serialize(root);
        System.out.println(result);

        String source = "3,9,20,#,#,15,7";
        System.out.println(test.serialize(test.deserialize(source)));
    }


    public static final String STR_SPLIT = ",";
    public static final String STR_NULL = "#";

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append(STR_NULL).append(STR_SPLIT);
                continue;
            }
            res.append(node.val).append(STR_SPLIT);
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.equals("")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(STR_SPLIT);
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals(STR_NULL)) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals(STR_NULL)) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
