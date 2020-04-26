package dynamicProgramming;

/*
 * Link: https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 * Given N, consider a convex N-sided polygon with vertices labelled 
 * A[0], A[i], ..., A[N-1] in clockwise order.
 * Suppose you triangulate the polygon into N-2 triangles.  
 * For each triangle, the value of that triangle is the product of the labels of the vertices, 
 * and the total score of the triangulation is the sum of these values over all 
 * N-2 triangles in the triangulation.
 * Return the smallest possible total score that you can achieve with some triangulation of the polygon.

 Example 1:

	Input: [1,2,3]
	Output: 6
	Explanation: The polygon is already triangulated, and the score of the only triangle is 6.
	
 Example 2:

	Input: [3,7,4,5]
	Output: 144
	Explanation: There are two triangulations, with possible scores: 3*7*5 + 4*5*7 = 245, 
	or 3*4*5 + 3*4*7 = 144.  The minimum score is 144.

	Example 3:

	Input: [1,3,1,4,1,5]
	Output: 13
	Explanation: The minimum score triangulation has score 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13.
 
	Note:
		3 <= A.length <= 50
		1 <= A[i] <= 100
 */
public class MinimumScoreTriangulationofPolygon {
	public int minScoreTriangulation(int[] A) {
		int dp[][] = new int[A.length][A.length];
		return minScoreTriangulation(A, dp, 0, A.length - 1);
	}

	private int minScoreTriangulation(int[] A, int dp[][], int start, int end) {
		if (end - start < 2) {
			return 0;
		}
		if (dp[start][end] != 0) {
			return dp[start][end];
		}
		dp[start][end] = Integer.MAX_VALUE;
		for (int i = start + 1; i < end; i++) {
			dp[start][end] = Math.min(dp[start][end], A[start] * A[i] * A[end] 
													+ minScoreTriangulation(A, dp, start, i)
													+ minScoreTriangulation(A, dp, i, end));
		}
		return dp[start][end];
	}
}
