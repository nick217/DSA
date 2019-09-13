package dynamicProgramming;

/*
 * Link: https://leetcode.com/problems/range-sum-query-2d-immutable/
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined 
 * by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Example:
	Given matrix = [
  		[3, 0, 1, 4, 2],
  		[5, 6, 3, 2, 1],
  		[1, 2, 0, 1, 5],
  		[4, 1, 0, 1, 7],
  		[1, 0, 3, 0, 5]
	]

	sumRegion(2, 1, 4, 3) -> 8
	sumRegion(1, 1, 2, 2) -> 11
	sumRegion(1, 2, 2, 4) -> 12
	
	Note:
	You may assume that the matrix does not change.
	There are many calls to sumRegion function.
	You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DImmutable {
	private int[][] matrix;

	/**
	 * Your NumMatrix object will be instantiated and called as such:
	 * RangeSumQuery2DImmutable obj = new RangeSumQuery2DImmutable(matrix); 
	 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
	 */
	public RangeSumQuery2DImmutable(int[][] input) {
		matrix = input;
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] += matrix[i - 1][j];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		if (row1 == 0) {
			for (int i = col1; i <= col2; i++) {
				sum += matrix[row2][i];
			}
		} else {
			for (int i = col1; i <= col2; i++) {
				sum += matrix[row2][i] - matrix[row1 - 1][i];
			}
		}
		return sum;
	}

}
