package multithreading.producer_consumer;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueBuffer implements Buffer {

	LinkedBlockingQueue<Data> queue = new LinkedBlockingQueue<>();
	int i = 0;
	
	@Override
	public synchronized void insert(Data item) {
		try {
			Data data = (Data) item;
			data.data = data.data + " : " + i; 
			System.out.println(" <- " + data.data);
			queue.put(item);
			i++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Data remove() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
