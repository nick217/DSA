package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 	Link: https://leetcode.com/problems/permutations/
 * 	Given a collection of distinct integers, return all possible permutations.

	Example:

	Input: [1,2,3]
	Output:
	[
  		[1,2,3],
  		[1,3,2],
  		[2,1,3],
  		[2,3,1],
  		[3,1,2],
  		[3,2,1]
	]
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		List<Integer> initial = new ArrayList<>();
		initial.add(nums[0]);
		List<List<Integer>> finalList = new ArrayList<>();
		finalList.add(initial);

		for (int i = 1; i < nums.length; i++) {
			List<List<Integer>> newList = new ArrayList<>();
			for (List l : finalList) {
				for (int j = 0; j <= l.size(); j++) {
					List<Integer> list = new ArrayList<>(l);
					list.add(j, nums[i]);
					newList.add(list);
				}
			}
			finalList = newList;
		}

		return finalList;
	}
}
