# [Leetcode 146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/)

## 1. 题目描述

运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

## 2. 思路

使用 `LinkedHashMap` 存储。

- 每次 `get` 的时候，先移除原有的数据，再将这个数据放到最后的位置。
- `put` 操作的时候，如果已经有`key`，则先移除。并判断是否到达最大容量，如果到达，则将第一个数据删除，然后把新数据放到最后的位置。

## 3. java 代码

```java
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
```

