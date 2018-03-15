package linkedList;

public class Lists<T> extends LList<T> implements List<T>{
	private Node indexNode;
	@Override
	public void add(int index, T value) throws ListAccessError {
		indexNode.setNext(new Node(value));
	}
	@Override
	public T remove(int index) throws ListAccessError {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T get(int index) throws ListAccessError {
		// TODO Auto-generated method stub
		return null;
	}
}
