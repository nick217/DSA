package array;

/*
 * 	Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 	Given an array of integers nums sorted in ascending order, 
 * 	find the starting and ending position of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).

	If the target is not found in the array, return [-1, -1].

	Example 1:

	Input: nums = [5,7,7,8,8,10], target = 8
	Output: [3,4]

	Example 2:

	Input: nums = [5,7,7,8,8,10], target = 6
	Output: [-1,-1]
 */
public class FindFirstandLastPositionofElementinSortedArray {
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		return search(nums, target, 0, nums.length - 1);
	}

	public int[] search(int[] nums, int target, int start, int end) {
		if (start > end) {
			return new int[] { -1, -1 };
		}
		int mid = (start + end) / 2;
		if (nums[mid] < target) {
			return search(nums, target, mid + 1, end);
		} else if (nums[mid] > target) {
			return search(nums, target, start, mid - 1);
		} else {
			int[] left = search(nums, target, start, mid - 1);
			int[] right = search(nums, target, mid + 1, end);
			int[] range = new int[2];
			if (left[0] != -1) {
				range[0] = left[0];
			} else {
				range[0] = mid;
			}
			if (right[1] != -1) {
				range[1] = right[1];
			} else {
				range[1] = mid;
			}
			return range;
		}
	}
}
