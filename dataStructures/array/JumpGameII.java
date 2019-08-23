package array;

/*
 * Link: https://leetcode.com/problems/jump-game-ii/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Your goal is to reach the last index in the minimum number of jumps.

	Example:

	Input: [2,3,1,1,4]
	Output: 2
	Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
    
	Note: You can assume that you can always reach the last index.
 */
public class JumpGameII {
	public int jump(int[] nums) {

		int size = nums.length;
		nums[size - 1] = 0;

		for (int i = size - 2; i >= 0; i--) {

			if (i + nums[i] >= size - 1) {
				nums[i] = 1;
			} else {
				int j = Math.min(nums[i], size - i - 1);
				nums[i] = Integer.MAX_VALUE;
				for (int k = 1; k <= j; k++) {
					if (nums[i + k] != Integer.MAX_VALUE) {
						nums[i] = Math.min(nums[i], nums[i + k] + 1);
					}

				}
			}
		}

		return nums[0];
	}
}
