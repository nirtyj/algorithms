package epi.searching;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindKthElementTest {

	@Test
	public void test() {
		// 0 ,1, 2, 3, 4, 5, 6
		List<Integer> A = Arrays.asList(3, 1, 2, 0, 4, 6, 5);
		assertEquals(6, FindKthElement.findKthLargest(A, 1));
		assertEquals(5, FindKthElement.findKthLargest(A, 2));
		assertEquals(4, FindKthElement.findKthLargest(A, 3));
		assertEquals(3, FindKthElement.findKthLargest(A, 4));
		assertEquals(2, FindKthElement.findKthLargest(A, 5));
		assertEquals(1, FindKthElement.findKthLargest(A, 6));
		assertEquals(0, FindKthElement.findKthLargest(A, 7));
		A.set(2, 6);
		assertEquals(6, FindKthElement.findKthLargest(A, 1));
		assertEquals(6, FindKthElement.findKthLargest(A, 2));
		assertEquals(5, FindKthElement.findKthLargest(A, 3));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		// 12 10 6 4 4 3 0 0 -7
		assertEquals(12, FindKthElement.findKthLargest(A, 1));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(10, FindKthElement.findKthLargest(A, 2));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(6, FindKthElement.findKthLargest(A, 3));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(4, FindKthElement.findKthLargest(A, 4));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(4, FindKthElement.findKthLargest(A, 5));

		// -7, 0, 0, 3, 4, 4, 6, 10, 12
		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(3, FindKthElement.findKthLargest(A, 6));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(4, FindKthElement.findKthLargest(A, 5));
		for (int i = 0; i < A.size(); i++) {
			if (i > 3) {
				assertTrue(A.get(i) >= 4);
			} else if (i < 4) {
				assertTrue(A.get(i) <= 4);
			}
		}
	}

	@Test
	public void test1() {

		List<Integer> C = Arrays.asList(9, 5);
		assertEquals(9, FindKthElement.findKthLargest(C, 1));
		assertEquals(5, FindKthElement.findKthSmallest(C, 1));

		List<Integer> B = Arrays.asList(3, 2, 3, 5, 7, 3, 1);
		assertEquals(3, FindKthElement.findKthSmallest(B, 4));

		List<Integer> A = Arrays.asList(123);
		assertEquals(123, FindKthElement.findKthLargest(A, 1));
	}

	@Test
	public void test2() {

		List<Integer> A = Arrays.asList(3, 1, 2, 0, 4, 6, 5);
		assertEquals(0, FindKthElement.findKthSmallest(A, 1));
		assertEquals(1, FindKthElement.findKthSmallest(A, 2));
		assertEquals(2, FindKthElement.findKthSmallest(A, 3));
		assertEquals(3, FindKthElement.findKthSmallest(A, 4));
		assertEquals(4, FindKthElement.findKthSmallest(A, 5));
		assertEquals(5, FindKthElement.findKthSmallest(A, 6));
		assertEquals(6, FindKthElement.findKthSmallest(A, 7));
		A.set(2, 6);
		assertEquals(6, FindKthElement.findKthSmallest(A, 6));
		assertEquals(6, FindKthElement.findKthSmallest(A, 7));
		assertEquals(5, FindKthElement.findKthSmallest(A, 5));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		// -7 0 0 3 4 4 6 10 12
		assertEquals(-7, FindKthElement.findKthSmallest(A, 1));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(0, FindKthElement.findKthSmallest(A, 2));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(0, FindKthElement.findKthSmallest(A, 3));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(3, FindKthElement.findKthSmallest(A, 4));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(4, FindKthElement.findKthSmallest(A, 5));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(4, FindKthElement.findKthSmallest(A, 6));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(6, FindKthElement.findKthSmallest(A, 7));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(10, FindKthElement.findKthSmallest(A, 8));

		A = Arrays.asList(0, -7, 3, 4, 4, 12, 6, 10, 0);
		assertEquals(12, FindKthElement.findKthSmallest(A, 9));

		assertEquals(4, FindKthElement.findKthSmallest(A, 6));
		for (int i = 0; i < A.size(); i++) {
			if (i < 4) {
				assertTrue(A.get(i) < 4);
			} else if (i > 5) {
				assertTrue(A.get(i) > 4);
			}
		}
	}
}
