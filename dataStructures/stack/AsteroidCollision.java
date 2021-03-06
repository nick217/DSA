package stack;

import java.util.Stack;

/*
 * 	Link: https://leetcode.com/problems/asteroid-collision/
 * 	We are given an array asteroids of integers representing asteroids in a row.

	For each asteroid, the absolute value represents its size, and the sign represents its direction 
	(positive meaning right, negative meaning left). Each asteroid moves at the same speed.

	Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
	If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

	Example 1:
	Input: 
		asteroids = [5, 10, -5]
	Output: [5, 10]
	Explanation: 
		The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.

	Example 2:
	Input: 
		asteroids = [8, -8]
	Output: []
	Explanation: 
		The 8 and -8 collide exploding each other.

	Example 3:
	Input: 
		asteroids = [10, 2, -5]
	Output: [10]
	Explanation: 
	The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.

	Example 4:
	Input: 
		asteroids = [-2, -1, 1, 2]
	Output: [-2, -1, 1, 2]
	Explanation: 
	The -2 and -1 are moving left, while the 1 and 2 are moving right.
	Asteroids moving the same direction never meet, so no asteroids will meet each other.
	
	Note:

	The length of asteroids will be at most 10000.
	Each asteroid will be a non-zero integer in the range [-1000, 1000].
 */
public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		if (asteroids.length == 0 || asteroids.length == 1) {
			return asteroids;
		}
		Stack<Integer> s = new Stack<>();
		s.push(asteroids[0]);
		for (int i = 1; i < asteroids.length; i++) {
			push(s, asteroids[i]);
		}
		int[] output = new int[s.size()];
		for (int i = output.length - 1; i >= 0; i--) {
			output[i] = s.pop();
		}
		return output;
	}

	public void push(Stack<Integer> s, int eleToAdd) {
		if (s.isEmpty()) {
			s.push(eleToAdd);
		} else {
			int ele = s.peek();
			if (ele > 0 && eleToAdd < 0) {
				ele = s.pop();
				int absElement = Math.abs(ele);
				int absCurrentAsteroid = Math.abs(eleToAdd);
				if (absElement != absCurrentAsteroid) {
					ele = absElement < absCurrentAsteroid ? eleToAdd : ele;
					push(s, ele);
				}
			} else {
				s.push(eleToAdd);
			}
		}
	}
}
