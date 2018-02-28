/**
 * Leetcode 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/description/
 * 数组的方法splice方法：
 * arrayObject.splice(index,howmany,item1,.....,itemX)
 * splice() 方法可删除从 index 处开始的零个或多个元素，并且用参数列表中声明的一个或多个值来替换那些被删除的元素。
 * 如果从 arrayObject 中删除了元素，则返回的是含有被删除的元素的数组
 * @param {string} S
 * @return {string[]}
 */
var letterCasePermutation = function (S) {
    var lowS = S.toLowerCase();
    var resultList = [''];
    for (var i = 0; i < lowS.length; i++) {
        if (lowS[i] >= '0' && lowS[i] <= '9') {
            for (var k = 0; k < resultList.length; k++) {
                resultList[k] += lowS[i];
            }
        } else {
            var size = resultList.length;
            for (var j = 0; j < 2 * size; j += 2) {
                var temp = resultList[j];
                resultList[j] += lowS[i];
                resultList.splice(j + 1, 0, temp + lowS[i].toUpperCase());
            }
        }
    }
    return resultList;
};
var S = 'a1b2';
var resultList = letterCasePermutation(S);
for (var i = 0; i < resultList.length; i++) {
    console.log(resultList[i]);
}