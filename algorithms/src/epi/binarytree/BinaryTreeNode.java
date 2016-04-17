package epi.binarytree;

public class BinaryTreeNode<T extends Comparable<?>> {
	
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	BinaryTreeNode<T> parent;
	private BinaryTreeNode<T> sibling;
	private int nodesInLeftSubTree;

	public BinaryTreeNode() {
		
	}

	public BinaryTreeNode(T data) {
		this.data = data;
	}

	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right, BinaryTreeNode<T> parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public BinaryTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
	}

	public BinaryTreeNode<T> getSibling() {
		return sibling;
	}

	public void setSibling(BinaryTreeNode<T> sibling) {
		this.sibling = sibling;
	}
	
	@Override
	public String toString() {
		return TreePrinter.prettyPrintTree(this);
	}

	public int getNodesInLeftSubTree() {
		return nodesInLeftSubTree;
	}

	public void setNodesInLeftSubTree(int nodesInLeftSubTree) {
		this.nodesInLeftSubTree = nodesInLeftSubTree;
	}
}
