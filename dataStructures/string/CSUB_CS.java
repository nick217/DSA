package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Link: https://www.codechef.com/problems/CSUB
 * Given a string S consisting of only 1s and 0s, 
 * find the number of substrings which start and end both in 1.
 * In this problem, a substring is defined as a sequence of continuous characters 
 * Si, Si+1, ..., Sj where 1 ≤ i ≤ j ≤ N.
 * 
 * First line contains T, the number of testcases. 
 * Each testcase consists of N(the length of string) in one line and string in second line.
 * 
 * For each testcase, print the required answer in one line.
 * 
 * Constraints
 * 		1 ≤ T ≤ 10^5
		1 ≤ N ≤ 10^5
		Sum of N over all testcases ≤ 10^5
		
	Example
	Input:
	2
	4
	1111
	5
	10001

	Output:
	10
	3

	Explanation
	#test1: All substrings satisfy.
	#test2: Three substrings S[1,1], S[5,5] and S[1,5] satisfy.
 */
public class CSUB_CS {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			long count = 0;
			long subStr = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (str.charAt(i) == '1') {
					count++;
					subStr += count;
				}
			}
			System.out.println(subStr);
		}
	}
}
