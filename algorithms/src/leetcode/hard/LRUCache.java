package leetcode.hard;

import java.util.HashMap;

/**
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache(2);

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
public class LRUCache {

	class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int capacity;
	private Node head = null;
	private Node end = null;
	private HashMap<Integer, Node> map = new HashMap<>();

	/**
	 * Leetcode verified
	 * @param capacity
	 */
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public void set(int key, int value) {

		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			addAtHead(node);

		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
			}
			addAtHead(created);
			map.put(key, created);
		}
	}

	private void addAtHead(Node node) {

		Node tempHead = head;
		if (tempHead == null) {
			head = node;
		} else {
			node.next = tempHead;
			node.pre = null;
			tempHead.pre = node;
			head = node;
		}

		if (end == null)
			end = head;
	}

	private void remove(Node node) {
		Node prev = node.pre;
		Node next = node.next;
		if (prev != null) {
			prev.next = next;
		} else {
			head = next;
		}

		if (next != null) {
			next.pre = prev;
		} else {
			end = prev;
		}
	}

	public int get(int key) {

		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			addAtHead(n);
			return n.value;
		} else {
			return -1;
		}
	}
}
