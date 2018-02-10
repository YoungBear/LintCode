/**
 * 141. x的平方根
 * http://www.lintcode.com/zh-cn/problem/sqrtx/
 * @param x: An integer
 * @return: The sqrt of x
 */
const sqrt = function (x) {

    if(x === 0){
        return 0;
    }
    var begin = 1;
    var end = x;
    var middle = (begin + end) / 2;
    while (begin <= end){
        if (x / parseInt(middle) === parseInt(middle)) {
            return parseInt(middle);
        } else if (x / parseInt(middle) > parseInt(middle)) {
            begin = parseInt(middle) + 1;
        } else {
            end = parseInt(middle) - 1;
        }
        middle = (begin + end) / 2;
    }
    return parseInt(middle);
};

console.log(sqrt(2));
console.log(sqrt(4));
console.log(sqrt(6));
console.log(sqrt(8));
console.log(sqrt(9));
console.log(sqrt(10));


