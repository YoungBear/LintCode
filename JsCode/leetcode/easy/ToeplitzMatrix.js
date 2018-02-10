/**
 * @param {number[][]} matrix
 * @return {boolean}
 */
var isToeplitzMatrix = function (matrix) {
    if (matrix === null || matrix.length === 0 || matrix[0].length === 0) {
        return false;
    }
    var m = matrix.length;
    var n = matrix[0].length;
    for (var i = 0; i < m; i++) {
        var value = matrix[i][0];
        for (var j = 1; i + j < m && j < n; j++) {
            if (value !== matrix[i + j][j]) {
                return false;
            }
        }
    }
    for (j = 1; j < n; j++) {
        value = matrix[0][j];
        for (i = 1; i < m && i + j < n; i++) {
            if (value !== matrix[i][i + j]) {
                return false;
            }
        }
    }
    return true;
};


var matrix1 = [[1, 2, 3, 4], [5, 1, 2, 3], [9, 5, 1, 2]];
console.log(isToeplitzMatrix(matrix1));
var matrix2 = [[1, 2], [2, 2]];
console.log(isToeplitzMatrix(matrix2));
var matrix3 = [[65, 98, 57]];
console.log(isToeplitzMatrix(matrix3));