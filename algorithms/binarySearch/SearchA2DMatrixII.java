package binarySearch;

import java.util.Arrays;

/*	Link: https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
 * 	Write an efficient algorithm that searches for a value in an m x n matrix. 
 * 	This matrix has the following properties:

	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	Example:

	Consider the following matrix:

	[
  		[1,   4,  7, 11, 15],
  		[2,   5,  8, 12, 19],
  		[3,   6,  9, 16, 22],
  		[10, 13, 14, 17, 24],
  		[18, 21, 23, 26, 30]
	]
	Given target = 5, return true.

	Given target = 20, return false.
 */
public class SearchA2DMatrixII {
	// Time Complexity -> O(n^2)
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		if (rows > 0) {
			int columns = matrix[0].length;
			int i, j;
			i = j = 0;
			while (i < rows && j < columns) {
				if (matrix[i][j] == target) {
					return true;
				}
				if (target < matrix[i][j]) {
					i++;
					j = 0;
				} else {
					j++;
					if (j >= columns) {
						j = 0;
						i++;
					}
				}
			}
		}
		return false;
	}

	// Time Complexity -> O(nlogn)
	public boolean searchMatrixIII(int[][] matrix, int target) {
		int rows = matrix.length;
		if (rows > 0) {
			int i = 0;
			while (i < rows) {
				int pos = Arrays.binarySearch(matrix[i], target);
				if (pos >= 0) {
					return true;
				}
				i++;
			}
		}
		return false;
	}

	// Time Complexity -> O(n)
	public boolean searchMatrixII(int[][] matrix, int target) {
		int rows = matrix.length;
		if (rows > 0) {
			int i = rows - 1;
			int j = 0;
			while (i >= 0 && j < matrix[0].length) {
				if (target == matrix[i][j]) {
					return true;
				}
				if (target < matrix[i][j]) {
					i--;
				} else {
					j++;
				}
			}
		}
		return false;
	}

}
