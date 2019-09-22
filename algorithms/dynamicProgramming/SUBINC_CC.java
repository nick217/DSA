package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 	Link: https://www.codechef.com/problems/SUBINC
 * 	Given an array A1, A2, ..., AN, count the number of subarrays of array A 
 * 	which are non-decreasing.
	A subarray A[i, j], where 1 ≤ i ≤ j ≤ N is a sequence of integers Ai, Ai+1, ..., Aj.

	A subarray A[i, j] is non-decreasing if Ai ≤ Ai+1 ≤ Ai+2 ≤ ... ≤ Aj. You have to 
	count the total number of such subarrays.

	Input
	The first line of input contains an integer T denoting the number of test cases. 
	The description of T test cases follows.

	The first line of each test case contains a single integer N denoting the size of array.

	The second line contains N space-separated integers A1, A2, ..., AN denoting the elements 
	of the array.

	Output
	For each test case, output in a single line the required answer.

	Constraints
	1 ≤ T ≤ 5
	1 ≤ N ≤ 105
	1 ≤ Ai ≤ 109
	
	Example
	Input:
	2
	4
	1 4 2 3	
	1
	5

	Output:
	6
	1
 */
public class SUBINC_CC {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(input[i]);
			}
			long count = 1;
			long start, end;
			start = end = 0;

			for (int i = 1; i < n; i++) {
				count++;
				if (arr[i] >= arr[i - 1]) {
					end++;
				} else {
					start = end = i;
				}
				count += end - start;
			}
			System.out.println(count);
		}
	}
}
