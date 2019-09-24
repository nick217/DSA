package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 	Link: https://www.codechef.com/problems/MANYCHEF
 * 	Chef Ciel wants to put a fancy neon signboard over the entrance of her restaurant. 
 * 	She has not enough money to buy the new one so she bought some old neon signboard 
 * 	through the internet. Ciel was quite disappointed when she received her order - some 
 * 	of its letters were broken. But she realized that this is even better - she could replace 
 * 	each broken letter by any letter she wants. So she decided to do such a replacement that 
 * 	the resulting signboard will contain the word "CHEF" as many times as possible.

	We can model the signboard as a string S having capital letters from 'A' to 'Z', inclusive, 
	and question marks '?'. Letters in the string indicate the intact letters at the signboard, 
	while question marks indicate broken letters. So Ciel will replace each question mark with 
	some capital letter and her goal is to get the string that contains as many substrings 
	equal to "CHEF" as possible. If there exist several such strings, she will choose the 
	lexicographically smallest one.

	Note 1. The string S = S1...SN has the substring "CHEF" if for some i we have 
		    SiSi+1Si+2Si+3 = "CHEF". The number of times "CHEF" is the substring of S is 
		    the number of those i for which SiSi+1Si+2Si+3 = "CHEF".
	
	Note 2. The string A = A1...AN is called lexicographically smaller than the string 
			B = B1...BN if there exists K from 1 to N, inclusive, 
			such that Ai = Bi for i = 1, ..., K-1, and AK < BK. In particular, 
			A is lexicographically smaller than B if A1 < B1. We compare capital letters 
			by their positions in the English alphabet. So 'A' is the smallest letter, 
			'B' is the second smallest letter, ..., 'Z' is the largest letter.

	Input
	The first line of the input contains an integer T denoting the number of test cases. 
	The description of T test cases follows. The only line of each test case contains a string S.

	Output
	For each test case, output a single line containing the content of the signboard 
	Chef Ciel will come up with. That is you should output the lexicographically smallest 
	string that could be obtained from the input string by replacing all its question marks 
	by some capital letters and having as many substrings equal to "CHEF" as possible.

	Constraints
	1 ≤ T ≤ 2013
	1 ≤ length of S ≤ 2013
	Each character in S is either a capital letter from 'A' to 'Z', inclusive, or the question 
	mark '?'.
	
	Example
	Input:
	6
	????CIELIS???E?
	????CIELISOUR???F
	T?KEITE?SY
	????????
	???C???
	?????

	Output:
	CHEFCIELISACHEF
	CHEFCIELISOURCHEF
	TAKEITEASY
	CHEFCHEF
	AAACHEF
	ACHEF
 */
public class MANYCHEF_CC {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s = br.readLine();
			int i = s.length() - 1;
			int count = 0;
			StringBuilder str = new StringBuilder(s);
			while (i >= 3) {
				switch (str.charAt(i)) {
				case '?': {
					if (s.charAt(i - 1) == '?' || s.charAt(i - 1) == 'E') {
						if (s.charAt(i - 2) == '?' || s.charAt(i - 2) == 'H') {
							if (s.charAt(i - 3) == '?' || s.charAt(i - 3) == 'C') {
								count++;
								str.setCharAt(i, 'F');
								str.setCharAt(i - 1, 'E');
								str.setCharAt(i - 2, 'H');
								str.setCharAt(i - 3, 'C');
								i -= 3;
							}
						}
					}
					break;
				}
				case 'F': {
					if (s.charAt(i - 1) == '?' || s.charAt(i - 1) == 'E') {
						if (s.charAt(i - 2) == '?' || s.charAt(i - 2) == 'H') {
							if (s.charAt(i - 3) == '?' || s.charAt(i - 3) == 'C') {
								count++;
								str.setCharAt(i, 'F');
								str.setCharAt(i - 1, 'E');
								str.setCharAt(i - 2, 'H');
								str.setCharAt(i - 3, 'C');
								i -= 3;
							}
						}
					}
					break;
				}
				}
				i--;
			}
			for (int k = 0; k < str.length(); k++) {
				if (str.charAt(k) == '?') {
					str.setCharAt(k, 'A');
				}
			}
			System.out.println(str.toString());
		}
	}
}
