package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Link: https://www.codechef.com/problems/LAPIN
 * Lapindrome is defined as a string which when split in the middle, 
 * gives two halves having the same characters and same frequency of each character. 
 * If there are odd number of characters in the string, we ignore the middle character 
 * and check for lapindrome. For example gaga is a lapindrome, 
 * since the two halves ga and ga have the same characters with same frequency. 
 * Also, abccab, rotor and xyzxy are a few examples of lapindromes. 
 * Note that abbaab is NOT a lapindrome. The two halves contain the same characters 
 * but their frequencies do not match. 
 * Your task is simple. Given a string, you need to tell if it is a lapindrome.
 * 
 * Input:
		First line of input contains a single integer T, the number of test cases.
		Each test is a single line containing a string S composed of only lowercase 
		English alphabet.
   Output:
		For each test case, output on a separate line: "YES" if the string is a lapindrome and "NO" if it is not.
   Constraints:
	1 ≤ T ≤ 100
	2 ≤ |S| ≤ 1000, where |S| denotes the length of S

   Example:
	Input:
		6
		gaga
		abcde
		rotor
		xyzxy
		abbaab
		ababc


	Output:
		YES
		NO
		YES
		YES
		NO
		NO
 */
public class LAPIN_CS {

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			int len = str.length();
			int firstPartEnd = (len / 2);
			int secondPartStart = firstPartEnd;
			if ((len & 1) == 1) {
				secondPartStart += 1;
			}
			int count[] = new int[26];
			for (int i = 0; i < firstPartEnd; i++) {
				count[str.charAt(i) - 'a']++;
			}
			for (int i = secondPartStart; i < len; i++) {
				count[str.charAt(i) - 'a']--;
			}
			boolean flag = true;
			for (int i = 0; i < 26; i++) {
				if (count[i] != 0) {
					flag = false;
				}
			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
