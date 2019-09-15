package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 * 	Link: https://www.codechef.com/problems/XORSUB
 * 	You have an array of integers A1, A2, ..., AN. The function F(P), where P is a subset of A, 
 * 	is defined as the XOR (represented by the symbol ⊕) of all the integers present in the subset. 
 * 	If P is empty, then F(P)=0.
 * 
 * 	Given an integer K, what is the maximum value of K ⊕ F(P), over all possible subsets P of A?

	Input
	The first line contains T, the number of test cases. 
	Each test case consists of N and K in one line, followed by the array A in the next line.

	Output
	For each test case, print the required answer in one line.

	Constraints
	1 ≤ T ≤ 10
	1 ≤ K, Ai ≤ 1000
	Subtask 1 (30 points):1 ≤ N ≤ 20
	Subtask 2 (70 points):1 ≤ N ≤ 1000
	
	Example
	Input:
	1
	3 4
	1 2 3

	Output:
	7
 */
public class XORwithSubset {

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String params[] = br.readLine().split(" ");
			int n = Integer.parseInt(params[0]);
			int k = Integer.parseInt(params[1]);

			params = br.readLine().split(" ");
			HashSet<Integer> hs = new HashSet<>();
			hs.add(0);
			for (int i = 0; i < n; i++) {
				int ele = Integer.parseInt(params[i]);
				HashSet<Integer> subset = new HashSet<>();
				for (int num : hs) {
					subset.add(num ^ ele);
				}
				hs.addAll(subset);
			}
			int max = 0;
			for (int num : hs) {
				max = (num ^ k) > max ? num ^ k : max;
			}
			System.out.println(max);
		}
	}
}
