/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 *
 * 数组相关方法：
 * indexOf() 搜索数组中的元素，并返回它所在的位置，如果没有该元素则返回-1
 * push() 向数组的末尾添加一个或更多元素，并返回新的长度。
 */
var intersection = function(nums1, nums2) {
    var temp1 = [];
    for(var i = 0; i < nums1.length; i++){
        if (temp1.indexOf(nums1[i]) === -1) {
            temp1.push(nums1[i]);
        }
    }
    var temp2 = [];
    for(var j = 0; j < nums2.length; j++){
        if (temp2.indexOf(nums2[j]) === -1) {
            temp2.push(nums2[j]);
        }
    }
    var result = [];
    for (var k = 0; k < temp2.length; k++){
        if (temp1.indexOf(temp2[k]) !== -1) {
            result.push(temp2[k])
        }
    }
    return result;
};

var arrA = [1, 2, 2, 1];
var arrB = [2, 2];
var result = intersection(arrA, arrB);
for(var t in result) {
    console.log(result[t]);
}