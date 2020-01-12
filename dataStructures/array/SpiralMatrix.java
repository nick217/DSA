package array;

import java.util.ArrayList;
import java.util.List;

/*
 * 	Link: https://leetcode.com/problems/spiral-matrix/
 * 	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

	Example 1:

	Input:
	[
 		[ 1, 2, 3 ],
 		[ 4, 5, 6 ],
 		[ 7, 8, 9 ]
	]
	Output: [1,2,3,6,9,8,7,4,5]
	
	Example 2:

	Input:
	[
  		[1, 2, 3, 4],
  		[5, 6, 7, 8],
  		[9,10,11,12]
	]
	Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		int rowStart, columnStart, rowEnd, columnEnd;
		rowStart = columnStart = 0;

		List<Integer> list = new ArrayList<>();
		rowEnd = matrix.length - 1;
		if (rowEnd < 0) {
			return list;
		}
		columnEnd = matrix[0].length - 1;
		while (rowStart <= rowEnd && columnStart <= columnEnd) {
			for (int i = rowStart; i <= columnEnd; i++) {
				list.add(matrix[rowStart][i]);
			}
			rowStart++;
			for (int i = rowStart; i <= rowEnd; i++) {
				list.add(matrix[i][columnEnd]);
			}
			columnEnd--;
			if (rowStart <= rowEnd) {
				for (int i = columnEnd; i >= columnStart; i--) {
					list.add(matrix[rowEnd][i]);
				}
				rowEnd--;
			}
			if (columnStart <= columnEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					list.add(matrix[i][columnStart]);
				}
				columnStart++;
			}
		}
		return list;
	}
}
