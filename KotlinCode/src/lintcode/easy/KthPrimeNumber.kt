package lintcode.easy

/**
 * 792. Kth Prime Number
 * http://www.lintcode.com/zh-cn/problem/kth-prime-number/
 * 判断素数n是第几个素数
 */
class KthPrimeNumber {

    /**
     * @param n: the number
     * @return: the rank of the number
     */
    fun kthPrime(n: Int): Int {
        var index = 0
        for (i in 2..n) {
            if (isPrime(i)) {
                index++
            }
        }
        return index
    }

    /**
     * 判断一个数是否为素数
     */
    fun isPrime(n: Int): Boolean {
        if (n == 0 || n == 1) {
            return false
        }
        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
    val test = KthPrimeNumber()
    println(test.kthPrime(2))
    println(test.kthPrime(3))
    println(test.kthPrime(5))
    println(test.kthPrime(7))
    println(test.kthPrime(11))
}