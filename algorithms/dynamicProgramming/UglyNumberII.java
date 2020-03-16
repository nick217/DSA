package dynamicProgramming;

/*
 * 	Link: https://leetcode.com/problems/ugly-number-ii/
 * 	Write a program to find the n-th ugly number.

	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

	Example:

	Input: n = 10
	Output: 12
	Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

	Note:  

	1 is typically treated as an ugly number.
	n does not exceed 1690.
 */
public class UglyNumberII {
	public int nthUglyNumber(int n) {
		int uglyNumbers[] = new int[n];
		int mul2, mul3, mul5;
		mul2 = mul3 = mul5 = 0;
		uglyNumbers[0] = 1;
		for (int i = 1; i < n; i++) {
			int a = uglyNumbers[mul2] * 2;
			int b = uglyNumbers[mul3] * 3;
			int c = uglyNumbers[mul5] * 5;
			uglyNumbers[i] = Math.min(a, Math.min(b, c));

			if (uglyNumbers[i] == a) {
				mul2++;
			}
			if (uglyNumbers[i] == b) {
				mul3++;
			}
			if (uglyNumbers[i] == c) {
				mul5++;
			}
		}
		return uglyNumbers[n - 1];
	}
}
