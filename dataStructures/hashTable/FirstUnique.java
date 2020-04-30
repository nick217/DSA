package hashTable;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.

	Implement the FirstUnique class:

	FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
	
	int showFirstUnique() returns the value of the first unique integer of the queue, 
	and returns -1 if there is no such integer.
	
	void add(int value) insert value to the queue.
 */
class FirstUnique {

	Set<Integer> elements;
	Set<Integer> uniqueElements;

	public FirstUnique(int[] nums) {
		elements = new HashSet<>();
		uniqueElements = new LinkedHashSet<>();
		for (int i : nums) {
			add(i);
		}
	}

	public int showFirstUnique() {
		if (uniqueElements.size() > 0) {
			for (int i : uniqueElements) {
				return i;
			}
		}
		return -1;
	}

	public void add(int value) {
		if (elements.contains(value)) {
			uniqueElements.remove(value);
		} else {
			elements.add(value);
			uniqueElements.add(value);
		}
	}
}

/**
 * Your FirstUnique object will be instantiated and called as such: FirstUnique
 * obj = new FirstUnique(nums); int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */