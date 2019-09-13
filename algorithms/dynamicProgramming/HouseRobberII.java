package dynamicProgramming;

/*	Link: https://leetcode.com/problems/house-robber-ii/
 * 	You are a professional robber planning to rob houses along a street. 
 * 	Each house has a certain amount of money stashed. 
 * 	All houses at this place are arranged in a circle. 
 * 	That means the first house is the neighbor of the last one. 
 * 	Meanwhile, adjacent houses have security system connected and it will automatically 
 * 	contact the police if two adjacent houses were broken into on the same night.

	Given a list of non-negative integers representing the amount of money of each house, 
	determine the maximum amount of money you can rob tonight without alerting the police.

	Example 1:

	Input: [2,3,2]
	Output: 3
	Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             	because they are adjacent houses.
	Example 2:

	Input: [1,2,3,1]
	Output: 4
	Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             	Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {
	public int rob(int[] nums) {
		int length = nums.length;
		if (length == 0)
			return 0;
		if (length == 1)
			return nums[0];
		if (length == 2)
			return Math.max(nums[0], nums[1]);
		if (length == 3) {
			int maximum = Integer.max(nums[1], nums[2]);
			return Integer.max(maximum, nums[0]);
		}

		int dp[] = new int[length];
		int maxFirstConsidered, maxLastConsidered;

		dp[0] = nums[0];
		dp[1] = nums[1];
		dp[2] = nums[2] + dp[0];
		for (int i = 3; i < length - 1; i++) {
			dp[i] = Integer.max(dp[i - 2], dp[i - 3]) + nums[i];
		}
		maxFirstConsidered = Integer.max(dp[length - 2], dp[length - 3]);
		dp[2] = nums[2];
		dp[3] = nums[3] + dp[1];
		for (int i = 4; i < nums.length; i++) {
			dp[i] = Integer.max(dp[i - 2], dp[i - 3]) + nums[i];
		}
		maxLastConsidered = Integer.max(dp[length - 2], dp[length - 1]);

		return Integer.max(maxFirstConsidered, maxLastConsidered);
	}
}
