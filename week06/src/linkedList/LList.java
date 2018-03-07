package linkedList;

public class LList<T> implements LinearList<T> {
private Node startNode;
	@Override
	public boolean isEmpty()
	{
		return startNode==null;
	}
}
