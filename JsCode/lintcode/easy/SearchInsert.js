/**
 * @param A: an integer sorted array
 * @param target: an integer to be inserted
 * @return: An integer
 */
const searchInsert = function (A, target) {
    for (var i = 0; i < A.length; i++) {
        if (A[i] >= target) {
            return i;
        }
    }
    return A.length;
};


var A = [1, 3, 5, 6];
var target1 = 5;
var target2 = 2;
var target3 = 7;
var target4 = 0;
console.log(searchInsert(A, target1));
console.log(searchInsert(A, target2));
console.log(searchInsert(A, target3));
console.log(searchInsert(A, target4));
