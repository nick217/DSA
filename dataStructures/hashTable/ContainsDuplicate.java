package hashTable;

import java.util.HashSet;

/*
 *  Link: https://leetcode.com/problems/contains-duplicate/
 *  Given an array of integers, find if the array contains any duplicates.

	Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

	Example 1:
	Input: [1,2,3,1]
	Output: true
	
	Example 2:
	Input: [1,2,3,4]
	Output: false
	
	Example 3:
	Input: [1,1,1,3,3,4,3,2,4,2]
	Output: true
 */
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		// Arrays.sort(nums);
		// for(int i = 0; i < nums.length-1; i++){
		// if(nums[i] == nums[i+1]){
		// return true;
		// }
		// }
		// return false;

		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(nums[i])) {
				return true;
			} else {
				hs.add(nums[i]);
			}
		}
		return false;
	}
}
