package misc;

import java.util.HashSet;
import java.util.Set;

/*
 * Link: https://leetcode.com/problems/single-number/
 * Given a non-empty array of integers, every element appears twice except for one. 
 * Find that single one.

	Note:

	Your algorithm should have a linear runtime complexity. 
	Could you implement it without using extra memory?

	Example 1:

	Input: [2,2,1]
	Output: 1
	
	Example 2:

	Input: [4,1,2,1,2]
	Output: 4
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		if (nums.length == 0)
			return 0;
		int sum = 0;
		Set<Integer> hs = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(nums[i])) {
				sum -= nums[i];
			} else {
				sum += nums[i];
				hs.add(nums[i]);
			}
		}
		return sum;
	}

	// With constant space using Bit Manipulation
	public int singleNumberII(int[] nums) {
		if (nums.length == 0)
			return 0;
		int missingNum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			missingNum ^= nums[i];
		}
		return missingNum;
	}
}
