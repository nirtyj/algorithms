package multithreading.producer_consumer;

/**
 * This is the producer thread for the bounded buffer problem.
 */

public class Producer implements Runnable {

	private Buffer buffer;
	private String name;

	public Producer(Buffer b, String name) {
		buffer = b;
		this.name = name;
	}

	public void run() {

		while (true) {
			SleepUtilities.nap();
			Data data = new Data("Produced by :" + this.name);
			buffer.insert(data);
		}
	}
}
