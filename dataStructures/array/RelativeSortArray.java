package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 	Link: https://leetcode.com/problems/relative-sort-array/
 * 	Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

	Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  
	Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 
	Example 1:

	Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
	Output: [2,2,2,1,4,3,3,9,6,7,19]
 

	Constraints:

	arr1.length, arr2.length <= 1000
	0 <= arr1[i], arr2[i] <= 1000
	Each arr2[i] is distinct.
	Each arr2[i] is in arr1.
 */
public class RelativeSortArray {
	public int[] relativeSortArrayBest(int[] arr1, int[] arr2) {
		int[] count = new int[1001], res = new int[arr1.length];
		for (int e : arr1)
			count[e]++;
		int idx = 0;
		for (int e : arr2) {
			for (int i = 0; i < count[e]; i++)
				res[idx++] = e;
			count[e] = 0;
		}

		for (int i = 0; i <= 1000; i++) {
			for (int j = 0; j < count[i]; j++)
				res[idx++] = i;
		}
		return res;
	}

	public int[] relativeSortArrayWithHashMap(int[] arr1, int[] arr2) {

		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			hm.put(arr2[i], 0);
		}
		int sorting_index = arr1.length;
		for (int i = 0; i < arr1.length && i < sorting_index; i++) {
			if (hm.containsKey(arr1[i])) {
				hm.put(arr1[i], hm.get(arr1[i]) + 1);
			} else {
				sorting_index--;
				int temp = arr1[sorting_index];
				arr1[sorting_index] = arr1[i];
				arr1[i] = temp;
				i--;
			}
		}
		int arr1_index = 0;
		for (int i = 0; i < arr2.length; i++) {
			int count = hm.get(arr2[i]);
			for (int j = 0; j < count; j++) {
				arr1[arr1_index++] = arr2[i];
			}
		}
		Arrays.sort(arr1, sorting_index, arr1.length);
		return arr1;
	}

	public int[] relativeSortArrayWithQuadraticTime(int[] arr1, int[] arr2) {

		int curr_index = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = curr_index; j < arr1.length; j++) {
				if (arr2[i] == arr1[j]) {
					arr1[j] = arr1[curr_index];
					arr1[curr_index] = arr2[i];
					curr_index++;
				}
			}
		}
		Arrays.sort(arr1, curr_index, arr1.length);
		return arr1;
	}
}
