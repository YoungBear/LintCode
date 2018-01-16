/**
 * 762. Prime Number of Set Bits in Binary Representation
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
 *
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
var countPrimeSetBits = function(L, R) {
    var PRIME_SET = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31];
    var result = 0;
    for(var i = L; i <= R; i++) {
        if (PRIME_SET.indexOf(count1(i)) !== -1 ) {
            result++;
        }
    }
    return result;
};

function count1(n) {
    var b;
    var result = 0;
    b = n.toString(2);
    for (var i = 0; i < b.length; i++) {
        if (b.charAt(i) === "1") {
            result++;
        }
    }
    return result;
}

console.log(countPrimeSetBits(6,10));
console.log(countPrimeSetBits(10,15));

