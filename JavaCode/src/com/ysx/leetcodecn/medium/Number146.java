package com.ysx.leetcodecn.medium;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/28 20:07
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description leetcode 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class Number146 {

    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public Number146(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 将当前数据放到最后边
            Integer value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // 如果存在则先删除
        map.remove(key);
        // 如果到达容量，则删除最老的数据
        if (map.size() == this.capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            if (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                map.remove(next.getKey());
            }
        }
        map.put(key, value);
    }
}
