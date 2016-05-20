package multithreading.producer_consumer;

class Consumer implements Runnable {

	private Buffer buffer;
	private String name;

	public Consumer(Buffer b, String name) {
		buffer = b;
		this.name = name;
	}

	public void run() {
		while (true) {
			SleepUtilities.nap();
			Data data = (Data) buffer.remove();
			System.out.println( name + " ------> " + data.data + "\"");
		}
	}
}