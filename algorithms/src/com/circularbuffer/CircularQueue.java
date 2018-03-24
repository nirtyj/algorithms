package com.circularbuffer;

import java.util.NoSuchElementException;

/**
 * Implement circular buffer with read & write functions
 * https://careercup.com/question?id=5666670023540736
 */
public class CircularQueue<T> {

	private final T[] elements;

	private int tail = 0;
	private int head = 0;
	private int numElements = 0;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("RingBuffer capacity must be positive.");
		elements = (T[]) new Object[size];
	}

	public void enqueue(T elem) {
		elements[tail] = elem;
		tail = (tail + 1) % elements.length;
		incrementNumElements();
	}

	private void incrementNumElements() {
		numElements++;
		if(numElements>=elements.length)
			numElements = elements.length;
	}

	public int capacity() {
		return elements.length;
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			T element = elements[head];
			head = (head + 1) % elements.length;
			decrementNumberOfElements();
			return element;
		}
	}

	private void decrementNumberOfElements() {
		numElements--;
		if(numElements <= 0)
			numElements = 0;
	}

	
	public int size() {
		return numElements;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public static void main(String[] args) throws InterruptedException {
		CircularQueue<String> buffer = new CircularQueue<>(3);
		boolean isEmpty = buffer.isEmpty();
		buffer.enqueue("1");
		buffer.enqueue("2");
		buffer.enqueue("3");
		System.out.println(buffer.dequeue());
		System.out.println(buffer.dequeue());
		System.out.println(buffer.dequeue());
		buffer.enqueue("4");
		System.out.println(buffer.dequeue());
		buffer.enqueue("5");
		buffer.enqueue("6");
		System.out.println(buffer.dequeue());
		buffer.enqueue("7");
		System.out.println(buffer.dequeue());
		System.out.println(buffer.dequeue());
		System.out.println(buffer.dequeue());
		System.out.println();

	}
}
