/**
 * @param obstacleGrid: A list of lists of integers
 * @return: An integer
 */
const uniquePathsWithObstacles = function (obstacleGrid) {
    if (obstacleGrid === null || obstacleGrid.length === 0 || obstacleGrid[0].length === 0) {
        return 0;
    }

    var m = obstacleGrid.length;
    var n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] === 1) {
        return 0;
    }

    var paths = [];
    for (var i = 0; i < m; i++) {
        var temp = [];
        for (var j = 0; j < n; j++) {
            temp.push(0);
        }
        paths.push(temp);
    }
    paths[0][0] = 1;

    for (j = 1; j < n; j++) {
        if (obstacleGrid[0][j] === 1) {
            paths[0][j] = 0;
        } else {
            paths[0][j] = paths[0][j - 1];
        }
    }

    for (i = 1; i < m; i++) {
        if (obstacleGrid[i][0] === 1) {
            paths[i][0] = 0;
        } else {
            paths[i][0] = paths[i - 1][0];
        }
    }

    for (i = 1; i < m; i++) {
        for (j = 1; j < n; j++) {
            if (obstacleGrid[i][j] === 1) {
                paths[i][j] = 0;
            } else {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
    }
    return paths[m - 1][n - 1];
};

var grids = [[0, 0, 0], [0, 0, 1], [0, 0, 0], [0, 0, 0]];
console.log(uniquePathsWithObstacles(grids));
