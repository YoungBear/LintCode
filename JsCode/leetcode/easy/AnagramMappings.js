/**
 * 760. Find Anagram Mappings
 * https://leetcode.com/problems/find-anagram-mappings/description/
 *
 * @param {number[]} A
 * @param {number[]} B
 * @return {number[]}
 */
var anagramMappings = function(A, B) {
    var len = A.length;
    var result = new Array(len);
    for(var i = 0; i < len; i++){
        for (var j = 0; j < len; j++) {
            if (A[i] === B[j]){
                result[i] = j;
                break;
            }
        }
    }
    return result;
};

var arrA = [12, 28, 46, 32, 50];
var arrB = [50, 12, 32, 46, 28];
var result = anagramMappings(arrA, arrB);
console.log(result.length)
for(var i in result) {
    console.log(result[i]);
}