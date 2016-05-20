package multithreading.producer_consumer;

public class MySemaphore {
	private Integer signals;
	private int bound;

	public MySemaphore(int startsWith) {
		this.signals = 0;
		this.bound = startsWith;
	}

	/* If the value is positive, then it represents the number of threads that can decrement without blocking.
	 *  If it is negative, then it represents the number of threads that have blocked and are waiting. 
	 *  If the value is zero, it means there are no threads waiting, but if a thread tries to decrement, it will block.
	 */

	// wait method releases the lock on the thread thats running and goes into the wait
	// while coming back it reacquires the lock and runs the command.
	// hence why release can be called even when threads are waiting to acquire 
	// inside the synchronized block

	/*
	 * Main difference between wait and sleep is that wait() method release the acquired monitor
	 *  when thread is waiting while Thread.sleep() method keeps the lock or monitor even if 
	 *  thread is waiting. Also, wait for method in Java should be called from synchronized method 
	 *  or block while there is no such requirement for sleep() method. 
	
	    Another difference is Thread.sleep() method is a static method and applies on current thread,
	    while wait() is an instance specific method and only got wake up if some other thread calls
	    notify method on same object. also, in the case of sleep, sleeping thread immediately goes
	    to Runnable state after waking up while in the case of wait, waiting for a thread first 
	    acquires the lock and then goes into Runnable state.
	 */
	public synchronized void acquire() throws InterruptedException {
		while (this.signals >= bound)
			wait();
		this.signals++;
	}

	public synchronized void release() throws InterruptedException {
		this.signals--;
		notify();
	}
}
