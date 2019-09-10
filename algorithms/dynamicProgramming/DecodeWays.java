package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/decode-ways/
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given a non-empty string containing only digits, determine the total number of ways to decode it.

	Example 1:

	Input: "12"
	Output: 2
	Explanation: It could be decoded as "AB" (1 2) or "L" (12).
	
	Example 2:

	Input: "226"
	Output: 3
	Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
	Map<String, Integer> hm = new HashMap<>();

	public int numDecodings(String s) {
		int length = s.length();
		if (s.charAt(0) == '0') {
			return 0;
		}
		if (length == 1) {
			if (Integer.parseInt(s) > 0) {
				hm.put(s, 1);
				return 1;
			} else {
				hm.put(s, 0);
				return 0;
			}
		}
		if (length == 2) {
			int num = Integer.parseInt(s);
			if (num <= 0) {
				hm.put(s, 0);
				return 0;
			}
			if (num > 26 && num % 10 == 0) {
				hm.put(s, 0);
				return 0;
			}
			if (num > 26 || s.charAt(1) == '0') {
				hm.put(s, 1);
				return 1;
			}
			hm.put(s, 2);
			return 2;
		}
		if (hm.containsKey(s)) {
			return hm.get(s);
		}
		int combinationsWithoutTheFirstDigit = numDecodings(s.substring(1));

		int firstTwoDigits = Integer.parseInt(s.substring(0, 2));

		int combinationsWithoutFirstTwoDigits = 0;
		if (firstTwoDigits <= 26) {
			combinationsWithoutFirstTwoDigits = numDecodings(s.substring(2));
		}
		int combinations = combinationsWithoutTheFirstDigit + combinationsWithoutFirstTwoDigits;
		hm.put(s, combinations);
		return combinations;
	}
}
