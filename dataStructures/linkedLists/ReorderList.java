package linkedLists;

/*
 * Link: https://leetcode.com/problems/reorder-list/
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

	You may not modify the values in the list's nodes, only nodes itself may be changed.

	Example 1:

		Given 1->2->3->4, reorder it to 1->4->2->3.
	Example 2:

		Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head != null) {
			ListNode slow, fast;

			slow = fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode mid = slow.next;
			slow.next = null;
			mid = reverseList(mid);
			ListNode start = head;
			ListNode temp;
			while (start != null && mid != null) {
				temp = start;
				start = start.next;
				temp.next = mid;
				mid = mid.next;
				temp = temp.next;
				temp.next = start;
			}
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode reverseHead = null;
		ListNode temp = null;
		while (head != null) {
			if (reverseHead == null) {
				reverseHead = temp = head;
				head = head.next;
				temp.next = null;
			} else {
				temp = head;
				head = head.next;
				temp.next = reverseHead;
				reverseHead = temp;
			}
		}
		return reverseHead;
	}
}
