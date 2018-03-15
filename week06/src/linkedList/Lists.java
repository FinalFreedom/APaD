package linkedList;

public class Lists<T> implements List<T>{
	private Node indexNode;
	@Override
	public void add(int index, T value) throws ListAccessError {
		indexNode.setNext(new Node(value));
	}
	@Override
	public T remove(int index) throws ListAccessError {
		Node temp = indexNode;
		for(int i=0;i<index-1;i++)
		{
			temp= temp.getNext();
		}
		T deleted = (T) temp.getNext().getValue();
		temp.setNext(null);
		return deleted;
	}
	@Override
	public T get(int index) throws ListAccessError {
		Node temp = indexNode;
		for(int i=0;i<index;i++)
		{
			if(temp.getNext()==null)
			{
				return null;
			}
			else
			{
				temp = temp.getNext();
			}
		}
		return (T) temp.getValue();
	}
	@Override
	public boolean isEmpty() {
		return indexNode==null;
	}
}
