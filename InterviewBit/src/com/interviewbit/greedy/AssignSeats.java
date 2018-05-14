package com.interviewbit.greedy;

/**
There is a row of seats. Assume that it contains N seats adjacent to each other. There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')

Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.

Return minimum value % MOD where MOD = 10000003

Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) -

. . . . x . . x x . . . x . .

Now to make them sit together one of approaches is -
    . . . . . . x x x x . . . . .

Following are the steps to achieve this -
1 - Move the person sitting at 4th index to 6th index -  
Number of jumps by him =   (6 - 4) = 2

2 - Bring the person sitting at 12th index to 9th index - 
Number of jumps by him = (12 - 9) = 3

So now the total number of jumps made = 
( 2 + 3 ) % MOD = 
5 which is the minimum possible jumps to make them seat together.

There are also other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.

For example bring them all towards the starting of the row i.e. start placing them from index 0. 
In that case the total number of jumps will be 
( 4 + 6 + 6 + 9 )%MOD 
= 25 which is very costly and not an optimized way to do this movement
*/
public class AssignSeats {

	int mod = 10000003;
	/**
	 * Verified by interview bit
	 * @param A
	 * @return
	 */
	public int seats(String A) {
		int medianPos = findMedian(A);
		if (medianPos == -1)
			return 0;
		int distance = shiftCloser(A.toCharArray(), medianPos);
		return distance % 10000003;
	}

	private int shiftCloser(char[] A, int medianPos) {
		int distance = 0;
		int i = 0;
		int j = medianPos;
		while (i < j) {
			while (i < j && A[j] == 'x')
				j--;

			while (i < j && A[i] == '.')
				i++;

			if (i >= j)
				break;
			distance = (distance + (j - i)) % mod;
			swap(A, i, j);
			i++;
			j--;
		}

		i = medianPos;
		j = A.length - 1;
		while (i < j) {
			while (i < j && A[i] == 'x')
				i++;

			while (i < j && A[j] == '.')
				j--;

			if (i >= j)
				break;
			distance = (distance + (j - i)) % mod;
			swap(A, j, i);
			i++;
			j--;
		}
		return distance;
	}

	private void swap(char[] arr, int i, int j) {
		arr[i] = '.';
		arr[j] = 'x';
	}

	private int findMedian(String A) {
		int count = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'x')
				count++;
		}
		if (count == 0)
			return -1;
		count = (count + 1) / 2;
		int mediancount = 0;
		for (int i = 0; i < A.length(); i++) {

			if (A.charAt(i) == 'x')
				mediancount++;
			if (mediancount == count)
				return i;
		}
		return -1;
	}
}
