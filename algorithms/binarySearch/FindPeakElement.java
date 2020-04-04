package binarySearch;

/*
 * 	Link: https://leetcode.com/problems/find-peak-element/
 * 	A peak element is an element that is greater than its neighbors.

	Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

	You may imagine that nums[-1] = nums[n] = -∞.

	Example 1:

	Input: nums = [1,2,3,1]
	Output: 2
	Explanation: 3 is a peak element and your function should return the index number 2.

	Example 2:

	Input: nums = [1,2,1,3,5,6,4]
	Output: 1 or 5 
	Explanation: Your function can return either index number 1 where the peak element is 2, 
	or index number 5 where the peak element is 6.

	Note:	Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int length = nums.length;
		if (length == 1 || nums[0] > nums[1]) {
			return 0;
		}
		if (nums[length - 2] < nums[length - 1]) {
			return length - 1;
		}
		return findPeakElement(nums, 1, length - 2);
	}

	public int findPeakElement(int[] nums, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
			return mid;
		}
		int left = findPeakElement(nums, start, mid - 1);
		int right = findPeakElement(nums, mid + 1, end);

		if (left == -1) {
			return right;
		}
		return left;
	}
}
