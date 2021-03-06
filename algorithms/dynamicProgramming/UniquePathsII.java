package dynamicProgramming;

/*
 * Link: https://leetcode.com/problems/unique-paths-ii/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	The robot can only move either down or right at any point in time. 
	The robot is trying to reach the bottom-right corner of the grid 
	(marked 'Finish' in the diagram below).

	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.

	Note: m and n will be at most 100.

	Example 1:

	Input:
	[
  		[0,0,0],
  		[0,1,0],
  		[0,0,0]
	]
	Output: 2
	Explanation:
	There is one obstacle in the middle of the 3x3 grid above.
	There are two ways to reach the bottom-right corner:
		1. Right -> Right -> Down -> Down
		2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		int pathCount[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
		pathCount[0][0] = 1;
		for (int i = 1; i < pathCount[0].length; i++) {
			if (obstacleGrid[0][i] == 1) {
				pathCount[0][i] = 0;
			} else {
				pathCount[0][i] = pathCount[0][i - 1];
			}
		}
		for (int i = 1; i < pathCount.length; i++) {
			if (obstacleGrid[i][0] == 1) {
				pathCount[i][0] = 0;
			} else {
				pathCount[i][0] = pathCount[i - 1][0];
			}
		}
		int i, j;
		i = 1;
		for (; i < obstacleGrid.length; i++) {
			for (j = 1; j < obstacleGrid[i].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					pathCount[i][j] = 0;
				} else {
					pathCount[i][j] = pathCount[i - 1][j] + pathCount[i][j - 1];
				}
			}
		}
		return pathCount[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}
