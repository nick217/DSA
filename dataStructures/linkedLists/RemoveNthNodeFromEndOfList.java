package linkedLists;
/*
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Given a linked list, remove the n-th node from the end of list and return its head.

	Example:

	Given linked list: 1->2->3->4->5, and n = 2.

	After removing the second node from the end, the linked list becomes 1->2->3->5.	
	
	Note:	Given n will always be valid.

	Follow up:	Could you do this in one pass?
 */
 class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class RemoveNthNodeFromEndOfList {

	//Method 1
	int counter = 0;

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		head.next = removeNthFromEnd(head.next, n);
		counter++;

		if (counter == n) {
			head = head.next;
		}

		return head;
	}
	
	//Method2
	public ListNode removeNthFromEndUsingTwoPointers(ListNode head, int n) {
        if(n <= 0){
            return head;
        }
        ListNode fast = head;
        while(n-- > 0 && fast != null){
            fast = fast.next;
        }
    
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
        }
        else {
            slow.next = slow.next.next;
        }
        return head;
    }
}
