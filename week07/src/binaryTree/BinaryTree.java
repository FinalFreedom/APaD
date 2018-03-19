package binaryTree;

public class BinaryTree<T extends Comparable<? super T>> implements BTree<T> {
	TreeNode<T> rootNode;
	
	@Override
	public void insert(T value)
	{
		if(rootNode==null)
		{
			rootNode = new TreeNode<T>(value);
		}
		else
		{
			if(value.compareTo(rootNode.value())<0)
			{
				rootNode.left().insert(value);
			}
			else
			{
				rootNode.right().insert(value);
			}
		}
	}
	@Override
	public T getValue()
	{
		return rootNode.value();
	}
	@Override
	public BTree<T> left()
	{
		return rootNode.left;
	}
	@Override
	public BTree<T> right()
	{
		return rootNode.right;
	}
	@Override
	public int getSize()
	{
		int size =0;
		if(rootNode!=null)
		{
			size =1;
			size+=rootNode.left().getSize();
			size+=rootNode.right().getSize();
		}
		return size;
	}
	@Override
	public T value() {
		return rootNode.value;
	}
}
