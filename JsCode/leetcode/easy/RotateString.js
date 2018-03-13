/**
 * Leetcode 796. Rotate String
 * https://leetcode.com/problems/rotate-string/description/
 * @param {string} A
 * @param {string} B
 * @return {boolean}
 */
var rotateString = function(A, B) {
    return A.length === B.length && (A + A).indexOf(B) !== -1;
};

var rotateString_old = function(A, B) {
    if (A.length !== B.length) {
        return false;
    }
    var length = A.length;
    for (var i = 0; i < length; i++) {
        var sub1 = A.substring(0,i);
        var sub2 = A.substring(i);
        var temp = sub2 + sub1;
        if (temp === B) {
            return true;
        }
    }
    return false;
};

var A1 = 'abcde';
var B1 = 'cdeab';
console.log(rotateString(A1, B1));

var A2 = 'abcde';
var B2 = 'abced';
console.log(rotateString(A2, B2));