package array;

import java.util.ArrayList;
import java.util.List;

/*
 * 	Link: https://leetcode.com/problems/combination-sum/
 * 	Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
 * 	find all unique combinations in candidates where the candidate numbers sums to target.

	The same repeated number may be chosen from candidates unlimited number of times.

	Note:

	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.

	Example 1:

	Input: candidates = [2,3,6,7], target = 7,
	A solution set is:
	[
  		[7],
  		[2,2,3]
	]

	Example 2:

	Input: candidates = [2,3,5], target = 8,
	A solution set is:
	[
  		[2,2,2,2],
  		[2,3,3],
  		[3,5]
	]
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> finalList = new ArrayList<>();
		return combinationSum(candidates, target, 0, new ArrayList<Integer>(), finalList);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target, int index, List<Integer> curr,
			List<List<Integer>> finalList) {
		if (target == 0) {
			finalList.add(new ArrayList<>(curr));
			return finalList;
		}
		if (target < 0) {
			return finalList;
		}
		List<Integer> l = new ArrayList<>(curr);
		for (int i = index; i < candidates.length; i++) {
			if ((target - candidates[i]) >= 0) {
				l.add(candidates[i]);
				combinationSum(candidates, target - candidates[i], i, l, finalList);
				l.remove(l.size() - 1);
			}
		}
		return finalList;
	}
}
