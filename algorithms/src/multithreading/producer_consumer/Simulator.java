package multithreading.producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class Simulator {

	public static void main(String[] args)
	{
		boolean stop = false;
		int numOfProducers = 20;
		int numOfConsumers = 10;
		List<Producer> producers = new ArrayList<Producer>();
		List<Consumer> consumers = new ArrayList<Consumer>();
		// LinkedBlockingQueueBuffer buffer = new LinkedBlockingQueueBuffer();
		MyBuffer buffer = new MyBuffer(8);
		for(int i=1 ; i<=numOfProducers; i++)
		{
			producers.add(new Producer(buffer, "p"+Integer.toString(i)));
		}
		
		for(int i=1 ; i<=numOfConsumers; i++)
		{
			consumers.add(new Consumer(buffer, "c"+Integer.toString(i)));
		}
		
		for(Producer p : producers)
			new Thread(p).start();
		
		for(Consumer c: consumers)
			new Thread(c).start();
		
		while(true)
		{
			if(stop == true)
				break;
		}
	}
}
