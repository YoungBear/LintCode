package com.ysx.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 平面列表
 * http://www.lintcode.com/zh-cn/problem/flatten-list/
 * <p>
 * 给定一个列表，该列表中的每个要素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。
 * 注意事项
 * 如果给定的列表中的要素本身也是一个列表，那么它也可以包含列表。
 */
public class FlattenSolution {
    public static void main(String[] args) {

    }

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> results = new ArrayList<>();
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                results.add(item.getInteger());
            } else {
                results.addAll(flatten(item.getList()));
            }
        }
        return results;
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
