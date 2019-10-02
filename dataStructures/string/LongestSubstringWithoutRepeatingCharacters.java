package string;

import java.util.HashMap;

/*
 * 	Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 	Given a string, find the length of the longest substring without repeating characters.

	Example 1:

	Input: "abcabcbb"
	Output: 3 
	Explanation: The answer is "abc", with the length of 3. 
	
	Example 2:

	Input: "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.
	
	Example 3:

	Input: "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not 
             a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int start, end;
		start = end = 0;
		HashMap<Character, Integer> hm = new HashMap<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			int pos = hm.containsKey(ch) ? hm.get(ch) : -1;
			if (pos < start) {
				hm.put(ch, i);
				end++;
			} else {
				count = count < (end - start) ? (end - start) : count;
				start = pos + 1;
				hm.put(ch, i);
				end = end < start ? start : end + 1;
			}
		}
		count = count < (end - start) ? (end - start) : count;
		return count;
	}
}
