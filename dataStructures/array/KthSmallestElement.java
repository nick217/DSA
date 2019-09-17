package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/*
 * Link: https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
 * Given an array arr[] and a number K where K is smaller than size of array, 
 * the task is to find the Kth smallest element in the given array. It is given that all 
 * array elements are distinct.

	Expected Time Complexity: O(n)

	Input:
	The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

	Output:
	Corresponding to each test case, print the kth smallest element in a new line.

	Constraints:
	1 <= T <= 100
	1 <= N <= 105
	1 <= arr[i] <= 105
	1 <= K <= N

	Example:
	Input:
	2
	6
	7 10 4 3 20 15
	3
	5
	7 10 4 20 15
	4

	Output:
	7
	15

	Explanation:
	Testcase 1: 3rd smallest element in the given array is 7.
 */
public class KthSmallestElement {
	public static void main(String[] args) throws IOException {
		// code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String s[] = (br.readLine()).split(" ");
			TreeSet<Integer> store = new TreeSet<>();
			for (int i = 0; i < n; i++) {
				store.add(Integer.parseInt(s[i]));
			}
			int k = Integer.parseInt(br.readLine());
			int i = 0;
			for (Integer num : store) {

				if (i == k - 1) {
					System.out.println(num);
					break;
				}
				i++;
			}
		}
	}
}
