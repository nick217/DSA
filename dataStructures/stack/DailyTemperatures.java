package stack;

import java.util.Stack;

/* Link: https://leetcode.com/problems/daily-temperatures/
 * Given a list of daily temperatures T, return a list such that, 
 * for each day in the input, tells you how many days you would have to wait until a 
 * warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. 
 * Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> nums = new Stack<>();
		Stack<Integer> pos = new Stack<>();
		for (int i = T.length - 1; i >= 0; i--) {
			Integer ele = T[i];

			while (!nums.isEmpty() && nums.peek() <= ele) {
				nums.pop();
				pos.pop();
			}
			if (nums.isEmpty()) {
				T[i] = 0;
			} else {
				T[i] = pos.peek() - i;
			}
			nums.push(ele);
			pos.push(i);
		}
		return T;
	}

	// Using single stack.
	public int[] dailyTemperaturesII(int[] T) {
		int[] ans = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = T.length - 1; i >= 0; --i) {
			while (!stack.isEmpty() && T[i] >= T[stack.peek()])
				stack.pop();
			ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return ans;
	}
}
