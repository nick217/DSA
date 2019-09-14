package misc;

import java.util.ArrayList;
import java.util.List;

/*	Link: https://leetcode.com/problems/subsets/
 * 	Given a set of distinct integers, nums, return all possible subsets (the power set).

	Note: The solution set must not contain duplicate subsets.

	Example:

	Input: nums = [1,2,3]
	Output:
	[
  		[3],
  		[1],
  		[2],
  		[1,2,3],
  		[1,3],
  		[2,3],
  		[1,2],
  		[]
]
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> powerSet = new ArrayList<>();
		powerSet.add(new ArrayList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> subsets = new ArrayList<>();
			for (List<Integer> subset : powerSet) {
				List<Integer> newSubSet = new ArrayList<>(subset);
				newSubSet.add(nums[i]);
				subsets.add(newSubSet);
			}
			powerSet.addAll(subsets);
		}
		return powerSet;
	}
}
