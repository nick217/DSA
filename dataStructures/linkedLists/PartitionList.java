package linkedLists;

/*
 * Link: https://leetcode.com/problems/partition-list/
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

   You should preserve the original relative order of the nodes in each of the two partitions.

	Example:

		Input: head = 1->4->3->2->5->2, x = 3
		Output: 1->2->2->4->3->5
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode lessHead, less;
		ListNode moreHead, more;

		lessHead = less = moreHead = more = null;
		while (head != null) {
			if (head.val < x) {
				if (lessHead == null) {
					lessHead = less = head;
				} else {
					less.next = head;
					less = less.next;

				}
			} else {
				if (moreHead == null) {
					moreHead = more = head;
				} else {
					more.next = head;
					more = more.next;

				}
			}
			head = head.next;
		}
		if (less != null) {
			less.next = null;
		}
		if (more != null) {
			more.next = null;
		}
		if (lessHead != null) {
			less.next = moreHead;
			return lessHead;
		}
		return moreHead;
	}
}
