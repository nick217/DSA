package binarySearch;

import java.util.Arrays;

/*	Link: https://leetcode.com/problems/search-a-2d-matrix/
 * 	Write an efficient algorithm that searches for a value in an m x n matrix.
 *  This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	Example 1:

		Input:
		matrix = [
  					[1,   3,  5,  7],
  					[10, 11, 16, 20],
  					[23, 30, 34, 50]
				]
		target = 3
		Output: true

	Example 2:

		Input:
		matrix = [
  					[1,   3,  5,  7],
  					[10, 11, 16, 20],
  					[23, 30, 34, 50]
				]
		target = 13
		Output: false
 */
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {

		int row = findRow(matrix, target);
		if (row == -1) {
			return false;
		}
		int pos = Arrays.binarySearch(matrix[row], target);
		return pos >= 0 ? true : false;

	}

	public int findRow(int[][] matrix, int target) {
		int begin = 0;
		int end = matrix.length - 1;
		if (end < 0) {
			return -1;
		}
		int width = matrix[0].length - 1;
		if (width < 0) {
			return -1;
		}
		while (begin <= end) {
			int mid = (begin + end) / 2;
			if (matrix[mid][0] <= target && target <= matrix[mid][width]) {
				return mid;
			}
			if (target < matrix[mid][0]) {
				end = mid - 1;
			} else {
				begin = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		
	}
}
