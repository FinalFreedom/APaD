package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class ReferenceCount<T> extends AdjacencyGraph<T> implements TopologicalSort<T>
{
	private Stack<T> traversal = new Stack<T>();
	private HashMap<T,Integer> countTable = new HashMap<T,Integer>();
	@Override
	public List<T> getSort() throws GraphError
	{
		setup();
		sort();
		return traversal;
	}
	
	private void setup() throws GraphError
	{
		for(T node: getNodes())
		{
			countTable.put(node,0);
		}
		for(T node:getNodes())
		{
			for(T neighbour:getNeighbours(node))
			{
				int i = countTable.get(neighbour);
				countTable.put(neighbour, ++i);
			}
		}
	}
	
	private void initialise()
	{
		for(T node: getNodes())
		{
			countTable.put(node,0);
		}
	}
	
	private void countRefrences() throws GraphError
	{
		for(T node:getNodes())
		{
			for(T neighbour:getNeighbours(node))
			{
				int i = countTable.get(neighbour);
				countTable.put(neighbour, ++i);
			}
		}
	}
	private void sort() throws GraphError
	{
		T node;
		while((node = nextReferenceZeroNode())!=null)
		{
			for(T neighbour:getNeighbours(node))
			{
				Integer count = countTable.get(neighbour);
				if(count!=null)
				{
					countTable.put(neighbour, count-1);
				}
				countTable.put(node, count-1);
			}
			countTable.remove(node);
			traversal.add(node);
		}
	}
	
	private T nextReferenceZeroNode()
	{
		for(Entry<T, Integer> node:countTable.entrySet())
		{
			if(node.getValue()==0)
			{
				return (T) node.getKey();
			}
		}
		return null;
	}
}