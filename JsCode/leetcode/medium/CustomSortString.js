/**
 * Leetcode: 791. Custom Sort String
 * https://leetcode.com/problems/custom-sort-string/description/
 * @param {string} S
 * @param {string} T
 * @return {string}
 */
var customSortString = function(S, T) {
    var arrayT = T.split('');
    var length = T.length;
    var flag = true;
    for (var i = 0; flag && i < length; i++) {
        flag = false;
        for (var j = 0; j < length - i - 1; j++) {
            if (S.indexOf(arrayT[j]) > S.indexOf(arrayT[j + 1])) {
                var temp = arrayT[j];
                arrayT[j] = arrayT[j + 1];
                arrayT[j + 1] = temp;
                flag = true;
            }
        }
    }
    return arrayT.join('');
};


var S = 'cba';
var T = 'abcfde';
console.log(customSortString(S, T));