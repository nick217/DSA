package string;

import java.util.ArrayList;

/*
 * 	Link: https://leetcode.com/problems/zigzag-conversion/submissions/
 * 	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of 
 * 	rows like this: (you may want to display this pattern in a fixed font for better 
 * 	legibility)
 * 
 * 	And then read line by line: "PAHNAPLSIIGYIR"
 * 	Example 1:

	Input: s = "PAYPALISHIRING", numRows = 3
	Output: "PAHNAPLSIIGYIR"

	Example 2:

	Input: s = "PAYPALISHIRING", numRows = 4
	Output: "PINALSIGYAHRPI"
	Explanation:

	P     I    N
	A   L S  I G
	Y A   H R
	P     I
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows <= 1) {
			return s;
		}
		ArrayList<ArrayList<Character>> ar = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			ar.add(new ArrayList<Character>());
		}
		int row = 0;
		boolean downDirection = true;
		ArrayList<Character> list;
		for (int i = 0; i < s.length(); i++) {
			list = ar.get(row);
			list.add(s.charAt(i));
			if (row == 0) {
				downDirection = true;
			} else if (row == (numRows - 1)) {
				downDirection = false;
			}
			row = downDirection ? row + 1 : row - 1;
		}
		StringBuilder br = new StringBuilder("");
		for (int i = 0; i < numRows; i++) {
			for (Character c : ar.get(i)) {
				br.append(c);
			}
		}
		return br.toString();
	}
	public static void main(String args[]){
		
	}
}
