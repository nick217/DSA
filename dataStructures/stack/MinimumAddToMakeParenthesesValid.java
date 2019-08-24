package stack;

import java.util.Stack;

/*	Link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

	Formally, a parentheses string is valid if and only if:

	It is the empty string, or
	It can be written as AB (A concatenated with B), where A and B are valid strings, or
	It can be written as (A), where A is a valid string.
	Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 	Example 1:

	Input: "())"
	Output: 1
	Example 2:

	Input: "((("
	Output: 3
	Example 3:

	Input: "()"
	Output: 0
	Example 4:

	Input: "()))(("
	Output: 4
 

	Note:

	S.length <= 1000
	S only consists of '(' and ')' characters.
 */
public class MinimumAddToMakeParenthesesValid {
	
	//2ms
	public int minAddToMakeValidWithStackDataType(String S) {
		Stack<Character> stack = new Stack<>();
		for (char c : S.toCharArray()) {

			if (stack.isEmpty() || c == '(') {
				stack.push(c);
			} else {

				if (stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}
		return stack.size();
	}
	
	//0ms
	public int minAddToMakeValid(String S) {
        int count = 0;
        int stackedelements = 0;
        for(char c: S.toCharArray()){
            if(c == '(')
                stackedelements++;
            else{
                if(stackedelements == 0)
                    count++;
                else
                    stackedelements--;
            }
        }
        return count+stackedelements;
    }
}
