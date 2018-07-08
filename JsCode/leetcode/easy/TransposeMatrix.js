/**
 * @auther  : youngbear
 * @email   : youngbear@aliyun.com
 * @time    : 2018/7/8 21:56
 * @blog    : https://blog.csdn.net/next_second
 * @github  : https://github.com/YoungBear
 * @file    : TransposeMatrix.py
 * @software: WebStorm
 * @description 矩阵的转置
 * Leetcode 868. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/description/
 */


var transpose = function(A) {
    var B = [];
    for (var i = 0; i < A[0].length; i++) {
        var temp = [];
        for (var j = 0; j < A.length; j++) {
            temp.push(A[j][i]);
        }
        B.push(temp);
    }
    return B;
};

var A1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
console.log(A1);
console.log(transpose(A1));

var A2 = [[1, 2, 3], [4, 5, 6]];
console.log(A2);
console.log(transpose(A2));
