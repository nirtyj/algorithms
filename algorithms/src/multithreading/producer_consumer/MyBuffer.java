package multithreading.producer_consumer;

import java.util.concurrent.Semaphore;

public class MyBuffer implements Buffer {

	private final int bufferSize;
	Object[] buffer;
	private int count; //number of items currently in the buffer
	private int in; // points to the next free position in the buffer
	private int out; // points to the first filled position in the buffer
	private int id;

	MySemaphore produerMutex = new MySemaphore(1); // new Semaphore(1);
	MySemaphore consumerMutex = new MySemaphore(1); // new Semaphore(1);
	MySemaphore emptySpace = new MySemaphore(0); // new Semaphore(0);
	MySemaphore availableSpace;

	long start = System.nanoTime();

	public MyBuffer(int bufferSize) {
		this.bufferSize = bufferSize;
		this.count = 0;
		this.in = 0;
		this.out = 0;
		this.buffer = new Object[this.bufferSize];
		availableSpace = new MySemaphore(this.bufferSize);
	}

	@Override
	public void insert(Object item) {

		try {
			// wait untill there is available space - that is buffer size
			availableSpace.acquire();

			// say that no one should modify the buffer
			produerMutex.acquire();

			// Segment to monitor

			if (id > 100 && id % 100 == 0)
				System.out.println(" Time for " + id + " is " + (System.nanoTime() - start) * 1.0e-9);

			Data data = (Data) item;
			data.data = data.data + " : " + id++;
			System.out.println("<-" + data.data);
			++count;
			buffer[in] = item;

			// Calculating the next in value

			//modulus (%) is the remainder of a division
			//for example, 0%3=0, 1%3=1, 2%3=2, 3%3=0, 4%3=1, 5%3=2
			in = (in + 1) % this.bufferSize;

			//mutual exclusion release. others can go ahead and modify the buffer
			produerMutex.release();

			// notify that there is no empty space
			emptySpace.release();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Object remove() {
		Object item = null;

		// wait until there is some space
		try {
			emptySpace.acquire();

			// say that no one should modify the buffer
			consumerMutex.acquire();

			--count;
			item = buffer[out];

			// calculating the next out value

			//modulus (%) is the remainder of a division
			//for example, 0%3=0, 1%3=1, 2%3=2, 3%3=0, 4%3=1, 5%3=2   
			out = (out + 1) % this.bufferSize;

			//mutual exclusion release. others can go ahead and modify the buffer
			consumerMutex.release();

			// notify that there is available space
			availableSpace.release();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

}
