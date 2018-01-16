# Kotlin笔记

**新建一个数组，指定长度：**

```
val result: IntArray = IntArray(len)
```

**使用intArrayOf()初始化数组元素，类似还有booleanArrayOf()等：**

```
val arrA = intArrayOf(12, 28, 46, 32, 50)
```

**for循环使用until，不包含最后的元素:**

```
for (i in 0 until len) {
    ...
}
```

**for循环使用..，包含最后一个元素：**

```
for (i in 0 .. len) {
    ...
}
```


