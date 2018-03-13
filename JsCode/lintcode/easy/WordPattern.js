/**
 * Lintcode 828. Word Pattern
 * http://www.lintcode.com/zh-cn/problem/word-pattern/
 * Leetcode 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/description/
 * @param {string} pattern
 * @param {string} str
 * @return {boolean}
 */
var wordPattern = function(pattern, str) {
    var strArray = str.split(' ');
    if (pattern.length !== strArray.length) {
        return false;
    }
    var length = pattern.length;
    var map = {};
    for(var i = 0; i < length; i++) {
        var ch = pattern[i];
        if (ch in map) {
            if (map[ch] !== strArray[i]) {
                return false;
            }
        } else {
            for (var key in map) {
                if (strArray[i] === map[key]) {
                    return false;
                }
            }
            map[ch] = strArray[i];
        }
    }
    return true;
};


var pattern1 = 'abba';
var str1 = 'dog cat cat dog';
console.log(wordPattern(pattern1, str1));

var pattern2 = 'abba';
var str2 = 'dog dog dog dog';
console.log(wordPattern(pattern2, str2));