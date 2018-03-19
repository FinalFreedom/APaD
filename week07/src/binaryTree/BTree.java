package binaryTree;

public interface BTree<T extends Comparable<? super T>> {
	/**
	 * Find the first correct placement for a comparable value
	 * in a binary tree and creates a new Node at that point
	 * @param value An instance of a comparable data type 
	 */
	public void insert(T value);
	/**
	 * Getter for the comparable data stored in a node
	 * @return Instance of comparable data stored at the Node
	 */
	public T value();
	/**
	 * Getter for the Node attached to the left branching path
	 * this may return a null value.
	 * @return Node attached to the left path of this Node
	 */
	public BTree<T> left();
	/**
	 * Getter for the Node attached to the right branching path
	 * this may return a null value.
	 * @return Node attached to the right path of this Node
	 */
	public BTree<T> right();
	/**
	 * Calculates the size of the tree starting
	 * at this instance of a Node.
	 * @return Number of filled Nodes in the Binary Tree
	 */
	public int getSize();
	/**
	 * Getter for the comparable data stored in a node
	 * @return Instance of comparable data stored at the Node
	 */
	public T getValue();

}
