/**
 * 792. Kth Prime Number
 * http://www.lintcode.com/zh-cn/problem/kth-prime-number/
 * 判断素数n是第几个素数
 */
var kthPrimeNumber = function (n) {
    var index = 0;
    for (var i = 2; i <= n; i++) {
        if (isPrime(i)) {
            index++;
        }
    }
    return index;
};

/**
 * 判断一个数是否为素数
 * @param n
 * @returns {boolean}
 */
var isPrime = function (n) {
    if ( n === 0 || n === 1){
        return false;
    }
    for (var i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
};

console.log(kthPrimeNumber(2));
console.log(kthPrimeNumber(3));
console.log(kthPrimeNumber(5));
console.log(kthPrimeNumber(7));
console.log(kthPrimeNumber(19));