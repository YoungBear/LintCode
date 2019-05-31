# 常用数学公共函数



[源代码](https://github.com/YoungBear/LintCode/blob/master/JavaCode/src/com/ysx/common/MathCommon.java)



## 1. 判断是否为素数

```java
    /**
     * 判断n是否为素数
     * @param n 自然数
     * @return 是否为素数
     */
    public static boolean isPrime(int n) {
        if (n ==0 || n == 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
```



## 2. 判断是否为2的幂

```java
    /**
     * 判断正整数n是否为2的幂
     * @param n 正整数
     * @return 是否为2的幂
     */
    public static boolean is2Power(int n) {
        return 0 == (n & (n -1));
    }
```




