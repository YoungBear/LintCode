/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function (J, S) {
    var lengthJ = J.length;
    var lengthS = S.length;
    var count = 0;
    for (var i = 0; i < lengthJ; i++) {
        for (var j = 0; j < lengthS; j++) {
            if (J[i] === S[j]) {
                count++;
            }
        }
    }
    return count;
};

console.log(numJewelsInStones("aA", "aAAbbbb"));
console.log(numJewelsInStones("z", "ZZ"));