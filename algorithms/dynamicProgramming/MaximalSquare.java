package dynamicProgramming;

/*
 * 	Link: https://leetcode.com/problems/maximal-square/
 * 	Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

	Example:

	Input: 

	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0

	Output: 4
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int r = matrix.length;
		if (r == 0) {
			return 0;
		}
		int foundOne = 0;
		int[][] intMatrix = convertToIntMatrix(matrix);
		int c = intMatrix[0].length;
		if (c == 0) {
			return 0;
		}
		for (int i = 0; i < c; i++) {
			if (intMatrix[0][i] == 1) {
				foundOne = 1;
			}
		}

		for (int i = 0; i < r; i++) {
			if (intMatrix[i][0] == 1) {
				foundOne = 1;
			}
		}

		int largestSq = foundOne;
		int possibleSq = 0;
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (intMatrix[i][j] != 0) {
					possibleSq = intMatrix[i - 1][j - 1];
					int curr = 0;
					while (curr != possibleSq) {
						curr++;
						if (intMatrix[i - curr][j] == 0 || intMatrix[i][j - curr] == 0) {
							curr--;
							break;
						}
					}
					if (possibleSq != 0) {
						intMatrix[i][j] = curr + 1;
					}
					largestSq = largestSq < intMatrix[i][j] ? intMatrix[i][j] : largestSq;
				}
			}
		}
		return largestSq * largestSq;
	}

	public int[][] convertToIntMatrix(char[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;

		int intMatrix[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				intMatrix[i][j] = matrix[i][j] - '0';
			}
		}

		return intMatrix;
	}
}
