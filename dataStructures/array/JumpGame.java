package array;
/*
 * Link: https://leetcode.com/problems/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Determine if you are able to reach the last index.

	Example 1:

	Input: [2,3,1,1,4]
	Output: true
	Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
	Example 2:

	Input: [3,2,1,0,4]
	Output: false
	Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
	
	//With Greedy Strategy
	public boolean canJump(int[] nums) {

		int size = nums.length;
		int possiblePos = size - 1;

		for (int i = size - 2; i >= 0; i--) {
			if (nums[i] + i >= possiblePos) {
				possiblePos = i;
			}
		}
		return possiblePos == 0;
	}

	// With Dynamic Programming -> O(n^2)
	public boolean canJumpWithDP(int[] nums) {
		if (nums.length <= 1) {
			return true;
		}
		int size = nums.length;
		boolean[] possible = new boolean[size];
		possible[size - 1] = true;

		for (int i = size - 2; i >= 0; i--) {
			possible[i] = false;
			int j = Math.min(nums[i], size);
			for (int k = 1; k <= j; k++) {
				if (possible[i + k]) {
					possible[i] = true;
					break;
				}
			}
		}
		return possible[0];
	}
}
