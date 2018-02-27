/**
 * Leetcode 788. Rotated Digits
 * https://leetcode.com/problems/rotated-digits/description/
 * @param {number} N
 * @return {number}
 */
var rotatedDigits = function(N) {
    var sum = 0;
    for (var i = 1; i <= N; i++) {
        if (isGoodDigit(i)) {
            sum++;
        }
    }
    return sum;
};

var isGoodDigit = function (n) {
    var t = n;
    var flag = false;
    while(t > 0) {
        var remainder = t % 10;
        if (3 === remainder || 4 === remainder || 7 === remainder){
            return false;
        } else if(2 === remainder || 5 === remainder || 6 === remainder || 9 === remainder) {
            flag = true;
        }
        t = parseInt(t / 10);
    }
    return flag;

};

console.log(rotatedDigits(30));
console.log(isGoodDigit(21));