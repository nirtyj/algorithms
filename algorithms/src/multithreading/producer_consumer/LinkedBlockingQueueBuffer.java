package multithreading.producer_consumer;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueBuffer implements Buffer {

	LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();
	int i = 0;
	
	@Override
	public synchronized void insert(Object item) {
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
	public Object remove() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
