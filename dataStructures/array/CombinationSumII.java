package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 	Link: https://leetcode.com/problems/combination-sum-ii/
 * 	Given a collection of candidate numbers (candidates) and a target number (target), 
 * 	find all unique combinations in candidates where the candidate numbers sums to target.

	Each number in candidates may only be used once in the combination.

	Note:

	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.

	Example 1:

	Input: candidates = [10,1,2,7,6,1,5], target = 8,
	A solution set is:
	[
  		[1, 7],
  		[1, 2, 5],
  		[2, 6],
  		[1, 1, 6]
	]

	Example 2:

	Input: candidates = [2,5,2,1,2], target = 5,
	A solution set is:
	[
  		[1,2,2],
  		[5]
	]
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> finalList = new ArrayList<>();
		Arrays.sort(candidates);
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
			if (i != index && candidates[i] == candidates[i - 1]) {
				continue;
			}
			if ((target - candidates[i]) < 0) {
				break;
			}
			l.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i + 1, l, finalList);
			l.remove(l.size() - 1);
		}
		return finalList;
	}
}
