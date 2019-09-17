package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Link: https://practice.geeksforgeeks.org/problems/equilibrium-point/0
 * 	Given an array A of N positive numbers. The task is to find the position where 
 * 	equilibrium first occurs in the array. Equilibrium position in an array is a position such 
 * 	that the sum of elements before it is equal to the sum of elements after it.

	Input:
	The first line of input contains an integer T, denoting the number of test cases. 
	Then T test cases follow. First line of each test case contains an integer N denoting 
	the size of the array. Then in the next line are N space separated values of the array A.

	Output:
	For each test case in a new  line print the position at which the elements are at 
	equilibrium if no equilibrium point exists print -1.

	Constraints:
	1 <= T <= 100
	1 <= N <= 10^6
	1 <= Ai <= 10^8

	Example:
	Input:
	2
	1
	1
	5
	1 3 5 2 2

	Output:
	1
	3

	Explanation:
	Testcase 1: Since its the only element hence its the only equilibrium point.
	Testcase 2: For second test case equilibrium point is at position 3 as elements 
	below it (1+3) = elements after it (2+2).
 */
public class EquilibriumPoint {
	public static void main(String[] args) throws IOException {
		// code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			String line = br.readLine(); // to read multiple integers line
			int sumR = 0, sumL = 0;
			boolean flag = true;

			String[] strs = line.trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(strs[i]);
				sumR += a[i];
			}
			for (int j = 0; j < n; j++) {
				sumL += a[j];
				if (sumL == sumR) {
					System.out.println(j + 1);
					flag = false;
					break;
				} else
					sumR -= a[j];
			}
			if (flag) {
				System.out.println(-1);
			}
			t--;
		}
	}
}
