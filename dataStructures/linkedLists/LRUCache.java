package linkedLists;

import java.util.HashMap;
import java.util.Map;

/*
 * 	Link: https://leetcode.com/problems/lru-cache/
 * 	Design and implement a data structure for Least Recently Used (LRU) cache. 
 * 	It should support the following operations: get and put.

	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
	otherwise return -1.
	put(key, value) - Set or insert the value if the key is not already present. 
	When the cache reached its capacity, it should invalidate the least recently used item 
	before inserting a new item.

	The cache is initialized with a positive capacity.

	Follow up:
	Could you do both operations in O(1) time complexity?

	Example:

	LRUCache cache = new LRUCache( 2 / capacity *\/ );

	cache.put(1, 1);
	cache.put(2, 2);
	cache.get(1);       // returns 1
	cache.put(3, 3);    // evicts key 2
	cache.get(2);       // returns -1 (not found)
	cache.put(4, 4);    // evicts key 1
	cache.get(1);       // returns -1 (not found)
	cache.get(3);       // returns 3
	cache.get(4);       // returns 4
 */
class LRUCache {
	class Node {
		int val;
		int key;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.val = value;
			this.key = key;
			next = null;
			prev = null;
		}
	}

	Map<Integer, Node> cache;
	int capacity;
	Node head; // points to most recent used element
	Node tail; // points to least recent used element

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			putElementAtHead(node);
			return node.val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			node.val = value;
			putElementAtHead(node);
		} else {
			if (capacity == 0) {
				removeElementAtEnd();
			}
			Node newNode = new Node(key, value);
			if (head == null) {
				head = tail = newNode;
			} else {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			}
			cache.put(newNode.key, newNode);
			capacity--;
		}
	}

	public void putElementAtHead(Node node) {
		if (head != node) {
			if (node == tail) {
				tail.prev.next = null;
				tail = tail.prev;
			} else {
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
			node.next = head;
			node.prev = null;
			head.prev = node;
			head = node;
		}
	}

	public void removeElementAtEnd() {

		cache.remove(tail.key);
		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
		capacity++;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */