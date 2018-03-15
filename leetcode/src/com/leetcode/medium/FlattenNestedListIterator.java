package com.leetcode.medium;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
Given a nested list of integers, implement an iterator to flatten it.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
*/
public class FlattenNestedListIterator {

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {
		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	/**
	 * Leetcode verified
	 */
	public class NestedIterator implements Iterator<Integer> {
		List<NestedInteger> list;
		int curr = 0;
		private Integer next = null;

		public NestedIterator(List<NestedInteger> nestedList) {
			list = nestedList;
		}

		@Override
		public Integer next() {
			if(next == null)
				next = findNext();
			if (next != null) {
				Integer temp = next;
				next = null;
				return temp;
			}
			throw new NoSuchElementException();
		}

		private Integer findNext() {
			if (list == null || list.isEmpty() || curr >= list.size())
				return null;
			NestedInteger val = list.get(curr);
			if (val.isInteger()) {
				curr++;
				return val.getInteger();
			} else {
				list.remove(curr);
				list.addAll(curr, val.getList());
				return findNext();
			}
		}

		@Override
		public boolean hasNext() {
			if(next == null)
				next = findNext();
			return next != null ? true : false;
		}
	}
}
