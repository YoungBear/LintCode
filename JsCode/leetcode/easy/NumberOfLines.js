/**
 * @auther  : youngbear
 * @email   : youngbear@aliyun.com
 * @time    : 2018/5/4 12:32
 * @blog    : https://blog.csdn.net/next_second
 * @github  : https://github.com/YoungBear
 * @file    : NumberOfLines.py
 * @software: WebStorm
 * Leetcode 806. Number of Lines To Write String
 * https://leetcode.com/problems/number-of-lines-to-write-string/description/
 */


const LINE_SIZE = 100;

/**
 * @param {number[]} widths
 * @param {string} S
 * @return {number[]}
 */
var numberOfLines = function(widths, S) {
    var result = [0, 0];
    var current_width = 0;
    var base = 'a'.charCodeAt(0);
    for (var i = 0; i < S.length; i++) {
        var w = widths[S[i].charCodeAt(0) - base];
        if (current_width + w > LINE_SIZE) {
            result[0]++;
            current_width = w;
        } else {
            current_width += w;
        }
    }
    result[0]++;
    result[1] = current_width;
    return result;
};

widths1 = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10];
S1 = "abcdefghijklmnopqrstuvwxyz";
console.log(numberOfLines(widths1, S1));

widths2 = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10];
S2 = "bbbcccdddaaa";
console.log(numberOfLines(widths2, S2));