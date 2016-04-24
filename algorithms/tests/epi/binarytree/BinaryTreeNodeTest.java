package epi.binarytree;

import static org.junit.Assert.*;

import org.junit.Test;

import epi.recursion.GenerateBinaryTrees;

public class BinaryTreeNodeTest {

	@Test
	public void test() {
		assertTrue(GenerateBinaryTrees.generateAllBinaryTrees(1).size() == 1);
		assertTrue(GenerateBinaryTrees.generateAllBinaryTrees(2).size() == 2);
		assertTrue(GenerateBinaryTrees.generateAllBinaryTrees(3).size() == 5);
		assertTrue(GenerateBinaryTrees.generateAllBinaryTrees(4).size() == 14);
		assertTrue(GenerateBinaryTrees.generateAllBinaryTrees(5).size() == 42);
		assertTrue(GenerateBinaryTrees.generateAllBinaryTrees(10).size() == 16796);
	}

}
