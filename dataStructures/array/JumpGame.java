package array;

public class JumpGame {
	
	//With Greedy Strategy
	public boolean canJump(int[] nums) {

		int size = nums.length;
		int possiblePos = size - 1;

		for (int i = size - 2; i >= 0; i--) {
			if (nums[i] + i >= possiblePos) {
				possiblePos = i;
			}
		}
		return possiblePos == 0;
	}

	// With Dynamic Programming -> O(n^2)
	public boolean canJumpWithDP(int[] nums) {
		if (nums.length <= 1) {
			return true;
		}
		int size = nums.length;
		boolean[] possible = new boolean[size];
		possible[size - 1] = true;

		for (int i = size - 2; i >= 0; i--) {
			possible[i] = false;
			int j = Math.min(nums[i], size);
			for (int k = 1; k <= j; k++) {
				if (possible[i + k]) {
					possible[i] = true;
					break;
				}
			}
		}
		return possible[0];
	}
}
