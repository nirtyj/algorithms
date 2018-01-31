package leetcode;

import java.util.HashMap;

/**
 * Leetcode verified
 * @author njaganathan
 *
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
