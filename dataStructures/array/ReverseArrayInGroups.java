package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*	Link: https://practice.geeksforgeeks.org/problems/reverse-array-in-groups/0
 * 	Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.

	Input:
	The first line of input contains a single integer T denoting the number of test cases. 
	Then T test cases follow. Each test case consist of two lines of input. The first line of 
	each test case consists of an integer N(size of array) and an integer K separated by a space. 
	The second line of each test case contains N space separated integers denoting the array 
	elements.

	Output:
	For each test case, print the modified array.

	Constraints:
	1 ≤ T ≤ 200
	1 ≤ N, K ≤ 10^7
	1 ≤ A[i] ≤ 10^18

	Example:
	Input
	2
	5 3
	1 2 3 4 5
	6 2
	10 20 30 40 50 60

	Output
	3 2 1 5 4
	20 10 40 30 60 50

	Explanation:	
	Testcase 1: Reversing groups in size 3, first group consists of elements 1, 2, 3. 
	Reversing this group, we have elements in order as 3, 2, 1.
 */
public class ReverseArrayInGroups {
	public static void main(String[] args) throws IOException {
		// code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n, k;
			String[] strs = br.readLine().trim().split("\\s+");
			n = Integer.parseInt(strs[0]);
			k = Integer.parseInt(strs[1]);

			Integer arr[] = new Integer[n];
			strs = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(strs[i]);
			}

			List<Integer> subReverseArr;
			int i = 0;
			while (i <= n - k + 1) {

				if (n - i >= k) {
					subReverseArr = Arrays.asList(Arrays.copyOfRange(arr, i, i + k));

				} else {
					subReverseArr = Arrays.asList(Arrays.copyOfRange(arr, i, n));
				}
				Collections.reverse(subReverseArr);
				for (int temp = 0; temp < subReverseArr.size(); temp++) {
					System.out.print(subReverseArr.get(temp) + " ");
				}
				i += k;
			}
			if (i < n) {
				subReverseArr = Arrays.asList(Arrays.copyOfRange(arr, i, n));
				Collections.reverse(subReverseArr);
				for (int temp = 0; temp < subReverseArr.size(); temp++) {
					System.out.print(subReverseArr.get(temp) + " ");
				}
			}
			System.out.println();
		}

	}
}
