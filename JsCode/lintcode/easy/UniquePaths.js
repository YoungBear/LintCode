/**
 * @param m: positive integer (1 <= m <= 100)
 * @param n: positive integer (1 <= n <= 100)
 * @return: An integer
 * 114. 不同的路径
 * http://www.lintcode.com/zh-cn/problem/unique-paths/
 */
const uniquePaths = function (m, n) {
    var nums = [];
    for (var i = 0; i < m; i++) {
        var temp = [];
        for (var j = 0; j < n; j++) {
            if (i === 0 || j === 0) {
                temp.push(1);
            } else {
                temp.push(0);
            }
        }
        nums.push(temp);
    }
    for (i = 1; i < m; i++) {
        for (j = 1; j < n; j++) {
            nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
        }
    }
    return nums[m - 1][n - 1];
};

console.log(uniquePaths(3, 3));
console.log(uniquePaths(4, 5));
