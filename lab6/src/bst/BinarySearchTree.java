package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Math;

public class BinarySearchTree<E> {
	BinaryNode<E> root; // Används också i BSTVisaulizer
	int size; // Används också i BSTVisaulizer
	private Comparator<E> ccomparator;

	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		this.ccomparator = (a, b) -> ((Comparable<E>) a).compareTo(b);

	}

	/**
	 * Constructs an empty binary search tree, sorted according to the specified
	 * comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
		size = 0;
		this.ccomparator = comparator;

	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		BinaryNode<E> n = new BinaryNode<E>(x);
		if (root == null) {
			root = n;
			size++;
			return true;
		}
		return add(root, x);

	}

	private boolean add(BinaryNode<E> node, E x) {

		int compareValue = ccomparator.compare(node.element, x);
		if (compareValue == 0) {
			return false; // inga dubletter
		} else if (compareValue > 0) { // om nod värdet är större än x
			if (node.right == null) {
				node.right = new BinaryNode<E>(x);
				size++;
				return true;
			} else {
				return add(node.right, x);

			}

		} // om nod värdet är mindre än x
		if (node.left == null) {
			node.left = new BinaryNode<E>(x);
			size++;
			return true;
		} else {
			return add(node.left, x);
		}

	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}

	private int height(BinaryNode<E> n) {
		int count = 0;
		if (root == null) {
			return 0;
		}
		while (n.left != null && n.right != null) {
			count++;
			height(n.left);
			height(n.right);

		}
		return count;
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;

	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		if (root == null) {
			System.out.println("Empty tree");
		} else {
			printTree(root);
		}

	}

	private void printTree(BinaryNode<E> n) {
		if (n != null) {
			printTree(n.left);
			System.out.println(" " + n.element);
			printTree(n.right);

		}

	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {

	}

	/*
	 * Builds a complete tree from the elements from position first to
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bt1 = new BinarySearchTree<>();
		bt1.add(10);
		bt1.add(12);
		bt1.add(9);
		System.out.println(bt1.size());

	}

}
