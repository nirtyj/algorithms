package multithreading;

/**
 * Original code by Silberschatz, Galvin, and Gagne
 * from Operating System Concepts with Java, 7th Edition
 * Modified by William McDaniel Albritton
 *
 * ReaderWriterSolution.java
 *
 * 
 * This class creates the reader and writer threads and
 * the database they will be using to coordinate access.
 */

import java.util.concurrent.Semaphore;

public class ReaderWriterSolution {
	public static final int NUM_OF_READERS = 3;
	public static final int NUM_OF_WRITERS = 2;

	public static void main(String args[]) {
		RWLock database = new Database();

		Thread[] readerArray = new Thread[NUM_OF_READERS];
		Thread[] writerArray = new Thread[NUM_OF_WRITERS];

		for (int i = 0; i < NUM_OF_READERS; i++) {
			readerArray[i] = new Thread(new Reader(i, database));
			readerArray[i].start();
		}

		for (int i = 0; i < NUM_OF_WRITERS; i++) {
			writerArray[i] = new Thread(new Writer(i, database));
			writerArray[i].start();
		}
	}
}

//****************************************************************

/**
 * An interface for reader-writer locks.
 *
 * In the text we do not have readers and writers
 * pass their number into each method. However we do so
 * here to aid in output messages.
 */

interface RWLock {
	public abstract void acquireReadLock(int readerNum);

	public abstract void acquireWriteLock(int writerNum);

	public abstract void releaseReadLock(int readerNum);

	public abstract void releaseWriteLock(int writerNum);
}

//****************************************************************

/**
 * Database.java
 *
 * This class contains the methods the readers and writers will use
 * to coordinate access to the database. Access is coordinated using semaphores.
 */

class Database implements RWLock {
	private int readerCount; // the number of active readers
	private Semaphore mutex; // controls access to readerCount
	private Semaphore db; // controls access to the database

	public Database() {
		readerCount = 0;
		mutex = new Semaphore(1);
		db = new Semaphore(1);
	}

	public void acquireReadLock(int readerNum) {
		try {
			//mutual exclusion for readerCount 
			mutex.acquire();
		} catch (InterruptedException e) {
		}

		++readerCount;

		// if I am the first reader tell all others
		// that the database is being read
		if (readerCount == 1) {
			try {
				db.acquire();
			} catch (InterruptedException e) {
			}
		}

		System.out.println("Reader " + readerNum + " is reading. Reader count = " + readerCount);
		//mutual exclusion for readerCount
		mutex.release();
	}

	public void releaseReadLock(int readerNum) {
		try {
			//mutual exclusion for readerCount
			mutex.acquire();
		} catch (InterruptedException e) {
		}

		--readerCount;

		// if I am the last reader tell all others
		// that the database is no longer being read
		if (readerCount == 0) {
			db.release();
		}

		System.out.println("Reader " + readerNum + " is done reading. Reader count = " + readerCount);

		//mutual exclusion for readerCount
		mutex.release();
	}

	public void acquireWriteLock(int writerNum) {
		try {
			db.acquire();
		} catch (InterruptedException e) {
		}
		System.out.println("Writer " + writerNum + " is writing.");
	}

	public void releaseWriteLock(int writerNum) {
		System.out.println("Writer " + writerNum + " is done writing.");
		db.release();
	}

}

//***********************************************************

/**
 * Reader.java
 *
 * A reader to the database.
 *
 */

class Reader implements Runnable {

	private RWLock database;
	private int readerNum;

	public Reader(int readerNum, RWLock database) {
		this.readerNum = readerNum;
		this.database = database;
	}

	public void run() {
		while (true) {
			SleepUtilities.nap();

			System.out.println("reader " + readerNum + " wants to read.");
			database.acquireReadLock(readerNum);

			// you have access to read from the database
			// let's read for awhile .....
			SleepUtilities.nap();

			database.releaseReadLock(readerNum);
		}
	};
}

//**************************************************************

/**
 * Writer.java
 *
 * A writer to the database.
 *
 */
class Writer implements Runnable {
	private RWLock database;
	private int writerNum;

	public Writer(int w, RWLock d) {
		writerNum = w;
		database = d;
	}

	public void run() {
		while (true) {
			SleepUtilities.nap();

			System.out.println("writer " + writerNum + " wants to write.");
			database.acquireWriteLock(writerNum);

			// you have access to write to the database
			// write for awhile ...
			SleepUtilities.nap();

			database.releaseWriteLock(writerNum);
		}
	}

}

//*****************************************************************

/**
 * Utilities for causing a thread to sleep.
 * Note, we should be handling interrupted exceptions
 * but choose not to do so for code clarity.
 *
 */

class SleepUtilities {
	/**
	* Nap between zero and NAP_TIME seconds.
	*/
	public static void nap() {
		nap(NAP_TIME);
	}

	/**
	* Nap between zero and duration seconds.
	*/
	public static void nap(int duration) {
		int sleeptime = (int) (NAP_TIME * Math.random());
		try {
			Thread.sleep(sleeptime * 1000);
		} catch (InterruptedException e) {
		}
	}

	private static final int NAP_TIME = 5;
}