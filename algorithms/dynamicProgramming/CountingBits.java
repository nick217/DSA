package dynamicProgramming;

/* Link: https://leetcode.com/problems/counting-bits/
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's 
 * in their binary representation and return them as an array.

	Example 1:

	Input: 2
	Output: [0,1,1]
	
	Example 2:

	Input: 5
	Output: [0,1,1,2,1,2]
	Follow up:

	-> It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
	   But can you do it in linear time O(n) /possibly in a single pass?
	-> Space complexity should be O(n).
	-> Can you do it like a boss? Do it without using any builtin function 
	   like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {

	public int[] countBits(int num) {
		int count[] = new int[num + 1];
		int max = 0;
		count[0] = 0;
		for (int i = 1; i <= num; i++) {
			if ((i & (i - 1)) == 0) {
				count[i] = 1;
				max = i;
			} else {
				count[i] = 1 + count[i - max];
			}
		}
		return count;
	}

	public int[] countBitsWithoutBitManipulation(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 0;
		for (int i = 1; i < num + 1; i++) {
			dp[i] = dp[i / 2] + i % 2;
		}
		return dp;
	}
}
