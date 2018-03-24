package com.circularbuffer;

/**
 * Implement circular buffer with read & write functions
 * https://careercup.com/question?id=5666670023540736
 */
public class RingBufferBlockingWait<T> {

	/* The actual ring buffer. */
	private final T[] elements;

	/* The write pointer, represented as an offset into the array. */
	private int offset = 0;

	/*
	 * The read pointer is encoded implicitly by keeping track of the number of
	 * unconsumed elements. We can then determine its position by backing up that
	 * many positions before the read position.
	 */
	private int unconsumedElements = 0;

	/**
     * Constructs a new RingBuffer with the specified capacity, which must be
     * positive.
     *
     * @param size The capacity of the new ring buffer.
     * @throws IllegalArgumentException If the capacity is negative.
     */
    @SuppressWarnings("unchecked")
    public RingBufferBlockingWait(int size) {
        /* Validate the size. */
        if (size <= 0)
            throw new IllegalArgumentException("RingBuffer capacity must be positive.");

        /* Construct the array to be that size. */
        elements = (T[]) new Object[size];
    }

	/**
	 * Appends an element to the ring buffer, blocking until space becomes
	 * available.
	 *
	 * @param elem
	 *            The element to add to the ring buffer.
	 * @throws InterruptedException
	 *             If the thread is interrupted before the insertion completes.
	 */
	public synchronized void add(T elem) throws InterruptedException {
		/*
		 * Block until the capacity is nonzero. Otherwise we don't have any space to
		 * write.
		 */
		while (unconsumedElements == elements.length)
			wait();

		/*
		 * Write the element into the next open spot, then advance the write pointer
		 * forward a step.
		 */
		elements[offset] = elem;
		offset = (offset + 1) % elements.length;

		/*
		 * Increase the number of unconsumed elements by one, then notify any threads
		 * that are waiting that more data is now available.
		 */
		++unconsumedElements;
		notifyAll();
	}

	/**
	 * Returns the maximum capacity of the ring buffer.
	 *
	 * @return The maximum capacity of the ring buffer.
	 */
	public int capacity() {
		return elements.length;
	}

	/**
	 * Observes, but does not dequeue, the next available element, blocking until
	 * data becomes available.
	 *
	 * @return The next available element.
	 * @throws InterruptedException
	 *             If the caller is interrupted before data becomes available.
	 */
	public synchronized T peek() throws InterruptedException {
		/* Wait for data to become available. */
		while (unconsumedElements == 0)
			wait();

		/*
		 * Hand back the next value. The index of this next value is a bit tricky to
		 * compute. We know that there are unconsumedElements elements waiting to be
		 * read, and they're contiguously before the write position. However, the buffer
		 * wraps around itself, and so we can't just do a naive subtraction; that might
		 * end up giving us a negative index. To avoid this, we'll use a clever trick in
		 * which we'll add to the index the capacity minus the distance. This value must
		 * be positive, since the distance is never greater than the capacity, and if we
		 * then wrap this value around using the modulus operator we'll end up with a
		 * valid index. All of this machinery works because
		 *
		 * (x + (n - k)) mod n == (x - k) mod n
		 * 
		 * And Java's modulus operator works best on positive values.
		 */
		return elements[(offset + (capacity() - unconsumedElements)) % capacity()];
	}

	/**
	 * Removes and returns the next available element, blocking until data becomes
	 * available.
	 *
	 * @return The next available element
	 * @throws InterruptedException
	 *             If the caller is interrupted before data becomes available.
	 */
	public synchronized T remove() throws InterruptedException {
		/* Use peek() to get the element to return. */
		T result = peek();

		/* Mark that one fewer elements are now available to read. */
		--unconsumedElements;

		/* Because there is more space left, wake up any waiting threads. */
		notifyAll();

		return result;
	}

	/**
	 * Returns the number of elements that are currently being stored in the ring
	 * buffer.
	 *
	 * @return The number of elements currently stored in the ring buffer.
	 */
	public synchronized int size() {
		return unconsumedElements;
	}

	/**
	 * Returns whether the ring buffer is empty.
	 *
	 * @return Whether the ring buffer is empty.
	 */
	public synchronized boolean isEmpty() {
		return size() == 0;
	}

	public static void main(String[] args) throws InterruptedException {
		RingBufferBlockingWait<String> buffer = new RingBufferBlockingWait<>(3);
		buffer.add("1");
		buffer.add("2");
		buffer.add("3");
		buffer.add("4");

		System.out.println(buffer.remove());
		System.out.println(buffer.remove());
		System.out.println(buffer.remove());
		System.out.println(buffer.remove());
		System.out.println();

	}
}
