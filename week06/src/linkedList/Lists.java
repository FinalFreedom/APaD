package linkedList;

public class Lists<T> implements List<T>{
	private Node<T> startNode = null;

	@Override
	public void add(int index, T value) throws ListAccessError
	{
		Node<T> addNode = new Node<T>(value); //Create the node to be added
		if(index ==0)
		{
			Node<T> temp = startNode.getNext();
			startNode = addNode;
			startNode.setNext(temp);
		}
		else
		{
			addNode.setNext(getNode(index));
			getNode(index-1).setNext(addNode);
		}
	}
	
	@Override
	public T remove(int index) throws ListAccessError
	{
		if(index==0)
		{
			T returnVal = startNode.getValue();
			startNode = startNode.getNext();
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
				return returnVal;
			}
			else
			{
				temp.setNext(null);
				return returnVal;
			}
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
		for(int i =0;i<index;i++)
		{
			if(temp.getNext()==null)
			{
				throw new ListAccessError("Index out of bounds");
			}
			else
			{
				temp = temp.getNext();
			}
		}
		return temp;
	}
}
