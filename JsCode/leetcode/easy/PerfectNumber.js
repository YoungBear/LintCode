/**
 * Leetcode 507. Perfect Number
 * https://leetcode.com/problems/perfect-number/description/
 * @param {number} num
 * @return {boolean}
 */
var checkPerfectNumber = function(num) {
    if (num <= 1) {
        return false;
    }
    var sum = 1;
    for (var i = 2; i <= Math.sqrt(num); i++) {
        if(num % i === 0) {
            sum += i;
            if (num / i !== i) {
                sum += num / i;
            }
        }
    }
    return num === sum;
};

for(var i = 1; i <= 100; i++) {
    if (checkPerfectNumber(i)) {
        console.log(i);
    }
}