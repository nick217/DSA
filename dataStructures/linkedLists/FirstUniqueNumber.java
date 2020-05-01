package linkedLists;

import java.util.HashMap;
import java.util.Map;

/*
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.

	Implement the FirstUniqueNumber class:

	FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
	
	int showFirstUnique() returns the value of the first unique integer of the queue, 
	and returns -1 if there is no such integer.
	
	void add(int value) insert value to the queue.
 */
public class FirstUniqueNumber {

    class Node{
        int val;
        int count;
        Node prev;
        Node next;
        Node(int val){
            this.val = val;
            count = 1;
        }
    }
    Map<Integer, Node> elementMap;
    Node head,tail;

    public FirstUniqueNumber(int[] nums) {
        head = tail = null;
        elementMap = new HashMap<>();
        for(Integer i: nums){
            add(i);
        }
    }
    
    public int showFirstUnique() {
        if(head == null){
            return -1;
        }
        return head.val;
    }
    
    public void add(int value) {
        Node node;
        if(elementMap.containsKey(value)){
            node = elementMap.get(value);
            node.count += 1;
            if(node == head){
                head = head.next;
            }
            if(node.prev != null){
                if(node == tail){
                  tail = tail.prev;
                  tail.next.prev = null;
                  tail.next = null; 
                }
                else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    node.next = node.prev = null;
                }
            }
        }
        else{
            node = new Node(value);
            elementMap.put(value, node);
            if(head == null){
                head = tail = node;
            }
            else{
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
    }
}

/**
 * Your FirstUniqueNumber object will be instantiated and called as such:
 * FirstUniqueNumber obj = new FirstUniqueNumber(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */

