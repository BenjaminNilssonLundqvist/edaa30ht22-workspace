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
		this.ccomparator = (a, b) -> ((Comparable<E>) b).compareTo(a);

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
		if (n == null) {
			return 0;
		} else {
			int left = height(n.left);
			int right = height(n.right);
			return Math.max(left, right) + 1; // fattar inte detta
		}

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
		ArrayList<E> nList= new ArrayList<>();
		
		toArray(root, nList);
		
		root = buildTree(nList, nList.indexOf(nList.get(0)), nList.indexOf(nList.get(nList.size()-1)));

	} 

	

	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		
		if(n!=null){
			toArray(n.left,sorted);
			//System.out.println(n);
			sorted.add(n.element);
			//nList.add(n);
			toArray(n.right,sorted);
			}
			//buildTree(sorted,(int)sorted.get(0),(int) sorted.get(sorted.size()-1));

	}

	/*
	 * Builds a complete tree from the elements from position first to
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		int mid= (first+last)/2;
		BinaryNode<E> node= new BinaryNode<E>(sorted.get(mid));

		if(first>last){
			node=null;
			return null;
		} else if(first==last){   // ?????
			return node;
		}else{
			node.left=buildTree(sorted, first, mid-1);
			node.right=buildTree(sorted, mid+1, last);
		} return node;
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
		BinarySearchTree<Integer> bt2 = new BinarySearchTree<>();
		for(int i=1;i<250;i++){
			bt2.add(i);
		}
		
		// for (int i = 10; i >= 1; i--) {
		// 	bt1.add(i);
		// }
		
		bt1.add(6);
		bt1.add(2);
		bt1.add(4);
		bt1.add(1);
		bt1.add(3);
		bt1.add(5);
		bt1.add(7);
		BSTVisualizer bstV = new BSTVisualizer("test", 300, 400);
		BSTVisualizer bstV2 = new BSTVisualizer("test", 300, 400);
		//bt1.rebuild();
		bstV.drawTree(bt2);
		bt2.rebuild();
		bstV2.drawTree(bt2);

		System.out.println("test");
		
		//System.out.println(bt1.height());

	}

}
