/**
 * 761. Smallest Subset
 * http://www.lintcode.com/zh-cn/problem/smallest-subset/
 * @param nums
 * @returns {number}
 */
var minElements = function (nums) {
    var lenA = nums.length;
    nums.sort();
    var sum = 0;
    for (var i = 0; i < lenA; i++){
        sum += nums[i];
    }
    var curSum = 0;
    for (var j = lenA - 1; j >= 0; j--) {
        if (curSum > sum - curSum) {
            return lenA - j - 1;
        } else {
            curSum += nums[j];
        }
    }
    return 0;
};

var arrA = [3,1,7,1];
var arrB = [2,1,2];
console.log(minElements(arrA));
console.log(minElements(arrB));