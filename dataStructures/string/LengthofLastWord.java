package string;

/*
 * 	Link: https://leetcode.com/problems/length-of-last-word/
 * 	Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * 	return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

	If the last word does not exist, return 0.

	Note: A word is defined as a maximal substring consisting of non-space characters only.

	Example:

	Input: "Hello World"
	Output: 5
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		int length = s.length();
		if (length == 0) {
			return 0;
		}
		int word_size = 0;
		int i = length - 1;
		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}
		while (i >= 0 && s.charAt(i) != ' ') {
			word_size++;
			i--;
		}
		return word_size;
	}
}
