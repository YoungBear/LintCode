/**
 * @param {number[]} nums
 * @return {number}
 */
var dominantIndex = function(nums) {
    var lenA = nums.length;
    if (lenA < 1) {
        return -1;
    } else if(lenA === 1) {
        return 0;
    }
    var max = nums[0];
    var maxIndex = 0;
    for (var i = 1; i < lenA; i++) {
        if (nums[i] > max) {
            max = nums[i];
            maxIndex = i;
        }
    }
    var second = 0;
    if (maxIndex === 0) {
        second = nums[1];
    } else {
        second = nums[0];
    }
    for (var j = 0; j < lenA; j++) {
        if (j === maxIndex) {
            continue;
        }
        if (nums[j] > second) {
            second = nums[j];
        }
    }
    if (max >= 2 * second) {
        return maxIndex;
    } else {
        return -1;
    }
};


var arrA = [3, 6, 1, 0];
var arrB = [1, 2, 3, 4];
var arrC = [0, 0, 3, 2];
console.log(dominantIndex(arrA));
console.log(dominantIndex(arrB));
console.log(dominantIndex(arrC));