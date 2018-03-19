package linkedList;

public class Lists<T> implements List<T>{
	private Node<T> startNode=null;
	private int nodeCount;
	@Override
	public void add(int index, T value) throws ListAccessError
	{
		Node<T> addNode = new Node<T>(value); //Create the node to be added
		if(isEmpty())
		{
			startNode = addNode;
		}
		else
		{
			if(getNode(index-1).getNext()==null)
			{
				getNode(index-1).setNext(addNode);
			}
			else
			{
				addNode.setNext(getNode(index));
				getNode(index).setNext(addNode);
			}
			nodeCount++;
		}
		
	}
	
	@Override
	public T remove(int index) throws ListAccessError
	{
		if(index==0)
		{
			T returnVal = startNode.getValue();
			startNode = startNode.getNext();
			nodeCount--;
			return returnVal;
		}
		else
		{
			Node<T> temp = getNode(index-1);
			Node<T> overwrite = getNode(index);
			T returnVal = (T) overwrite.getValue();
			if(overwrite.getNext()!=null)
			{
				temp.setNext(overwrite.getNext());
			}
			else
			{
				temp.setNext(null);
			}
			nodeCount--;
			return returnVal;
		}
	}
	
	@Override
	public T get(int index) throws ListAccessError
	{
		return (T) getNode(index).getValue();
	}
	
	@Override
	public boolean isEmpty() {
		return startNode==null;
	}
	
	private Node<T> getNode(int index) throws ListAccessError
	{
		Node<T> temp = startNode;
		if(index>nodeCount | index<0 | isEmpty())
		{
			throw new ListAccessError("Index out of bounds");
		}
		for(int i =0;i<index;i++)
		{
				temp = temp.getNext();
		}
		return temp;
	}
}
