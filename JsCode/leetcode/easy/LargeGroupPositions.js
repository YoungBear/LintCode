/**
 * @auther  : youngbear
 * @email   : youngbear@aliyun.com
 * @time    : 2018/5/10 22:37
 * @blog    : https://blog.csdn.net/next_second
 * @github  : https://github.com/YoungBear
 * @file    : LargeGroupPositions.py
 * @software: WebStorm
 * Leetcode 830. Positions of Large Groups
 * https://leetcode.com/problems/positions-of-large-groups/description/
 */


const LARGE_SIZE = 3;

/**
 * @param {string} S
 * @return {number[][]}
 */
var largeGroupPositions = function(S) {
    var result_list = [];
    for (var i = 0; i < S.length; i++) {
        var ch = S.charCodeAt(i);
        var j = i + 1;
        while (j < S.length && S.charCodeAt(j) === ch) {
            j++;
        }
        if (j - i >= LARGE_SIZE) {
            var item = [i, j - 1];
            result_list.push(item);
            i = j - 1;
        }
    }
    return result_list;
};

S1 = "abbxxxxzzy";
S2 = "abc";
S3 = "abcdddeeeeaabbbcd";

console.log(largeGroupPositions(S1));
console.log(largeGroupPositions(S2));
console.log(largeGroupPositions(S3));