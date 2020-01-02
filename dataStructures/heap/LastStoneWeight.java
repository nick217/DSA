package heap;

/*
 * 	Link: https://leetcode.com/problems/last-stone-weight/
 * 	We have a collection of rocks, each rock has a positive integer weight.

	Each turn, we choose the two heaviest rocks and smash them together.  
	Suppose the stones have weights x and y with x <= y.  The result of this smash is:

	If x == y, both stones are totally destroyed;
	If x != y, the stone of weight x is totally destroyed, and the stone of weight y has 
	new weight y-x.
	At the end, there is at most 1 stone left.  Return the weight of this stone 
	(or 0 if there are no stones left.)

 	Example 1:

	Input: [2,7,4,1,8,1]
	Output: 1
	Explanation: 
	We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
	we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
	we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
	we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 
	Note:

	1 <= stones.length <= 30
	1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
	public int lastStoneWeight(int[] nums) {
		int size = nums.length;
		if (size < 2) {
			return nums[0];
		}
		int x = nums[0];
		int y = nums[1];

		buildMaxHeap(nums, size);
		while (size >= 2) {
			x = nums[0];
			nums[0] = nums[size - 1];
			max_heapify(nums, 0, --size);
			y = nums[0];

			if (x != y) {
				x = x - y;
				nums[0] = x;
				max_heapify(nums, 0, size);
			} else {
				nums[0] = nums[size - 1];
				max_heapify(nums, 0, --size);
			}
		}
		if (size == 1) {
			return nums[0];
		} else {
			return 0;
		}
	}

	public void buildMaxHeap(int nums[], int size) {
		for (int i = (size / 2) - 1; i >= 0; i--) {
			max_heapify(nums, i, size);
		}
	}

	public void max_heapify(int nums[], int pos, int size) {

		int left = pos * 2 + 1;
		int right = pos * 2 + 2;
		int largest;
		if (left < size && nums[pos] < nums[left]) {
			largest = left;
		} else {
			largest = pos;
		}
		if (right < size && nums[largest] < nums[right]) {
			largest = right;
		}
		if (largest != pos) {
			int temp = nums[largest];
			nums[largest] = nums[pos];
			nums[pos] = temp;
			max_heapify(nums, largest, size);
		}
	}
}
