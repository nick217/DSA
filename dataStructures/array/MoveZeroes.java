package array;

/*
 * 	Link: https://leetcode.com/problems/move-zeroes/
 * 	Given an array nums, write a function to move all 0's to the end of it while 
 * 	maintaining the relative order of the non-zero elements.

	Example:

	Input: [0,1,0,3,12]
	Output: [1,3,12,0,0]
	
	Note:

	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int i = 0;
		int k = 0;
		while (i < nums.length) {
			if (nums[i] != 0) {
				nums[k++] = nums[i++];
			} else {
				i++;
			}
		}
		while (k < nums.length) {
			nums[k++] = 0;
		}
	}
}
